//Q7

class Factorial{
	static int factorial(int x){
		if(x>0){
			return xfactorial(x-1);
		}
		else{
			return 1;
		}
	}
	static void printFactorials(int x){
		for(int i=1;i<x+1;i++){
			System.out.println("Factorial of "+i+": =\t"+factorial(i));
		}
	}
	public static void main(String[] args){
		printFactorials(20);
	}
}	 