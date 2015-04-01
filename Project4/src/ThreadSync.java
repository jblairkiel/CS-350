import java.lang.Thread;
import java.util.concurrent.*;

public class ThreadSync
{
    private static boolean runFlag = true;
	
    	static Semaphore semDig = new Semaphore(2);
    	static Semaphore semLet = new Semaphore(3);
    	static Semaphore semSym = new Semaphore(1);

    public static void main( String[] args ) {

     	Runnable[] tasks = new Runnable[17];
    	Thread[] threads = new Thread[17];
    	// create 10 digit threads
    	for (int d=0; d<10; d++) {
    		tasks[d] = new PrintDigit((char)('0'+d));
    		threads[d] = new Thread( tasks[d] );
    		threads[d].start();
    	}
    	// create 6 letter threads
    	for (int d=0; d<6; d++) {
    		tasks[d+10] = new PrintLetter((char)('A'+d));
    		threads[d+10] = new Thread( tasks[d+10] );
    		threads[d+10].start();
    	}
       	// create a thread to print dash(-)
		tasks[16] = new PrintSymbol('*');
		threads[16] = new Thread( tasks[16] );
		threads[16].start();

		// Let the threads to run for a period of time
        try {
        	Thread.sleep(500000000);
        }
        catch (InterruptedException ex) {
        	ex.printStackTrace();
        }
        
        runFlag = false;
        // Interrupt the threads
        for (int i=0; i<17; i++) threads[i].interrupt();
    }
    
    public static class PrintDigit implements Runnable 
    {
    	private char c;
    	public PrintDigit(char c) { this.c=c; }
        public void run(){
    	    while (runFlag) {
       	        try {
					semDig.acquire();
       	        	System.out.printf( "%c", c);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	    }
        }
    }
    public static class PrintLetter implements Runnable 
    {
    	private char c;
    	public PrintLetter(char c) { this.c=c; }
        public void run(){
    	    while (runFlag) {
    	        try {
    	        	System.out.printf( "%c", c);
    	        	semLet.acquire();
    	        } catch (InterruptedException e) {
    	        	e.printStackTrace();
    	        }
    	    }
         }
    }
    public static class PrintSymbol implements Runnable 
    {
    	private char c;
    	public PrintSymbol(char c) { this.c=c; }
        public void run(){
    	    while (runFlag) {
    	    	try {
    	    		semSym.acquire();
    	    		System.out.printf( "%c", c);
    	    		semLet.release();
    	    		semLet.release();
    	    		
    	    		//semSym.acquire();
    	    		//System.out.printf( "%c", c);
    	    		//semLet.release();
    	    		//semLet.release();
    	    		//semLet.acquire();
    	    		//semSym.release();

    	    		//System.out.println("semDig is: " + semDig.availablePermits() + " ");
    	    		//semDig.release();
    	    		//semDig.release();
    	    		//System.out.println("semDig is: " + semDig.availablePermits() + " ");
    	    		System.out.print("\n");
    	    	} catch (InterruptedException e) {
    	    		e.printStackTrace();
    	    	}
    	    }
        }
    }
}