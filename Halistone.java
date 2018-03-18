//Q10

class Halistone{
	static void Halistone(int n){
		if(n==1){
			System.out.print(n+" ");
		}
		else{
			System.out.print(n+" ");
			if(n%2==0){
				Halistone(n/2);
			
			}
			else{
				Halistone(3*n+1);
			}
		}
			
	}
	public static void main(String[] args){
		Halistone(22);
	}
}