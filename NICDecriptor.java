//Q6

public class NICDecriptor {
	static void nicDecriptor(int NIC) {
		int year=1900+NIC/10000000;
		int middleValue=NIC/10000-(NIC/10000000)*1000;
		String gender="Male";
		int month=0;
		int monthTotal[]= {366,335,305,274,244,213,182,152,121,91,60,31,0};
		
		if(middleValue>366) {
			middleValue=middleValue-500;
			gender="Female";
		}
		for(int i=1;i<13;i++) {
			if(middleValue>monthTotal[i]) {
				month=13-i;
				middleValue-=monthTotal[i];
				break;
			}
		}
		System.out.println("NIC:"+NIC+"->"+year+" "+month+" "+middleValue+" "+gender);
		
		
	}
	public static void main(String[] args) {
		nicDecriptor(952681400);
	}

}
