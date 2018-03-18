//Q2

public class Diamond {
	static void Diamond() {
		for(int i=1;i<=10;i++){
			for(int j=1;j<=10-i;j++){
				System.out.print(" ");
				}
			for(int j=1;j<=i*2-1;j++){
				System.out.print('*');
				}
			System.out.println();
		}            
        for(int i=10-1;i>0;i--){
        	for(int j=1;j<=10-i;j++){
        		System.out.print(" ");
        		}
        	for(int j=1;j<=i*2-1;j++){
        		System.out.print('*');
        		}
        	System.out.println();
        }  
}
	public static void main(String[] args) {
		Diamond();

	}

}
