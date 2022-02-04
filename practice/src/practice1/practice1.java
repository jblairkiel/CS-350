package practice1;

public class practice1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
			for (int i=0; i<3; i++) {
				for (int j=0; j<9; j++) {
					switch (i) {
					case 0:
						break;
					case 1:
						continue;
					}
					System.out.println(10*i+j);
						if(j==4) {
							break;
						}
						else {
							continue;
						}
				}
			}
	}

}
