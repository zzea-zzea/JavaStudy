package data.realnum;

public class RealCalMain2 {

	public static void main(String[] args) {
		int a = 3;
		long b = 3L;
		long c = 3;
		double x = 3.14f;
		double y = Math.PI; // static μμ PI π
		
		// μ°μ μ°μ°
		double z1 = x+y;
		double z2 = x-y;
		double z3 = x*y;
		double z4 = x/y;
		
		System.out.println(z1);
		System.out.println(z2);
		System.out.println(z3);
		System.out.println(z4);
	
		// printf ν¬λ§· νμ formatμ κ°μ§κ³  μΆλ ₯
		// %f κ°μ μμμλ λμ€μ λ³νλ κ°μ΄λ λ³μ κ°μ λ°μ΄ν°κ° μμμμ μμΉμ μΆλ ₯
			// %fλ μ€μν μμμ  μλ¦¬μ λ°μ΄ν°λ₯Ό μΆλ ₯ν΄μ£Όλ μμμμ
			// %.3f == μμμ  3λ²μ§Έ μλ¦¬κΉμ§ μΆλ ₯
		
		System.out.printf("%f+%f=%f \n",3.14,0.99,1.00);
		System.out.printf("%.2f+%.2f=%.2f",3.14,0.99,1.00);
		
		System.out.printf("%.2f+%.2f=%.2f \n",10.0,20.123,1.333335);
		System.out.printf("%.2f+%.2f=%.2f \n",x,y,z1);
		System.out.printf("%.2f-%.2f=%f \n",x,y,z2);
		System.out.printf("%.2f*%.2f=%.2f \n",x,y,z3);
		System.out.printf("%.2f/%.2f=%f \n",x,y,z4);
		
		
		printRealNum(3.00,5.00,8.00);
		printRealNumCal(3.00,"+",5.00,3.00+5.00);
		printRealNumCal(3.00,"*",5.00,3.00*5.00);
		printRealNumCal(3.00,"-",5.00,3.00-5.00);
		printRealNumCal(3.00,"/",5.00,3.00/5.00);
	}
	
	public static void printRealNum(double fir,double sec, double res) {
		System.out.printf("%.2f+%.2f=%.2f \n",fir,sec,res);
	}
	
	public static void printRealNumCal(double fir,String op,double sec, double res) {
		System.out.printf("%.2f %s %.2f=%.2f \n",fir,op,sec,res);
	}

}
