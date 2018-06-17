
public class StairCase {

    public static void main(String[] args) {

    	int r=25;
    	int c=20;

    	for(int i=1;i<=r;i++){

    		if(i%5!=0){

    			for(int j=0;j<=c;j++){

					if(j<c){

    					System.out.print("  ");
					}
					else{
						System.out.print(" *");
					}

    			}

    			System.out.println(" ");
    		}

    		else{

    			for(int j=0;j<=c;j++){

    				if(j<(c-4)){

    					System.out.print("  ");
    				}

    				else if(j==c){

    					System.out.print(" *");
    					c=c-4;

    				}

    				else if(j>(c-4)){

    					System.out.print(" *");

    				}



    			}
    			System.out.println(" ");

    		}

    		//System.out.println(" ");




    	}

    }


}