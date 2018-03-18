//Question 9

class NCR{
	static int nCr(int n,int r){
		if(r==0 || r==n)
			return 1;
		else if(n>r)
			return nCr(n-1,r)+nCr(n-1,r-1);
		return 0;
	}
	public static void main(String[] args){	
		
			System.out.println(nCr(5,1));
	}
}
