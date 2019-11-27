package myMath;

public class Polynom_t {

	public static void main(String[] args) {
	//	test1();
		test2();
	}
	//public static void test1() {
		//Polynom p1 = new Polynom();
		//String[] monoms = {"1","x","x^2", "0.5x^2"};
		//for(int i=0;i<monoms.length;i++) {
	//	Monom m = new Monom(monoms[1]);
		///p1.add(m);
		//double aa = p1.area(0, 1, 0.0001);
		//p1.substract(p1);
		//System.out.println(p1);
	//}
	public static void test2() {
		Polynom p1 = new Polynom(), p2 =  new Polynom();
		String[] monoms1 = {"5", "1.7x","3.2x^2","-3","-1.5x^2"};
		String[] monoms2 = {"2"};
		for(int i=0;i<monoms1.length;i++) {
			Monom m = new Monom(monoms1[i]);
			p1.add(m);
		}
		for(int i=0;i<monoms2.length;i++) {
			Monom m = new Monom(monoms2[i]);
			p2.add(m);
		}
		Monom a=new Monom(5, 0);
		System.out.println("p1: "+p1);
		//System.out.println("p1: "+p2);
		//System.out.println("p2: "+p2);
		//p1.substract(p1);;
		//System.out.println(p1);
		//System.out.println("p1+p2: "+p1);
		p1.multiply(a);
		System.out.println(p1);
		//String s1 = p1.toString();
		//Polynom_able p3 = new Polynom();
		//p3=p1.copy();
		//System.out.println(p3);
		//p1.derivative();
		//System.out.println(p1);
		//double x=p1.area(0, 6, 0.4) ;
		//System.out.println(x);
		//Polynom_able pp1 = Polynom.parse(s1);
		//System.out.println("from string: "+pp1);
		//double  c=p1.root(-1, 1, 0.4);
		//System.out.println(c);
	}

}
