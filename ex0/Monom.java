
	package myMath;

	import java.util.Comparator;



import java.util.Comparator;



/**
 *  class  Monom of shape c*x^p.power is integer allways
 */
public class Monom implements function{
private double base; //coefficient
private int pow;//power of the MOnom

public static final double EPSILON = 0.0001;//for area
public static final Comparator<Monom> _Comp = new Monom_Comperator();
public static Comparator<Monom> getComp() {return _Comp;}




public Monom(double c, int p){

set_coefficient(c);
set_power(p);
}



public Monom(Monom other) {

this(other.get_coefficient(), other.get_power());
}


public double get_coefficient() {return this.base;}
public int get_power() {return this.pow;}






// derivative monom.

public Monom derivative() {
if(this.get_power()==0) {
	
return getNewZeroMonom();
}

this.set_coefficient(get_coefficient()*get_power());
this.set_power(get_power()-1);

return this;
}

public static Monom getNewZeroMonom() {return new Monom(0,0);}


//this method returns the result of put given x .

public double f(double x) {
double ans=0;
ans = this.get_coefficient()*Math.pow(x,this.get_power());

return ans;
}
//is the monom equals 0?
public boolean isZero() {return this.get_coefficient()==0;}
// ***************** add your code below **********************
//translate a string to monom
public Monom(String s) {
if(s==null)
throw new RuntimeException("Error can not init Empty String");
s=s.toLowerCase();//small letters


double   c=0;
int   p=0;
int x_ind=s.indexOf("x");


if(x_ind==-1) {
c=Double.parseDouble(s);
}
else if(x_ind==0) {

c=1.0;
p=1;
int p_ind=s.indexOf("^");
if(p_ind!=-1) {
String pow=s.substring(p_ind+1,s.length());
p=Integer.parseInt(pow);
}
}
else if((x_ind==1)&&(s.charAt(x_ind-1)=='-')) {
c=-1.0;
p=1;
int p_ind=s.indexOf("^");
if(p_ind!=-1) {
String pow=s.substring(p_ind+1,s.length());
p=Integer.parseInt(pow);
}

}
else
{
c=Double.parseDouble(s.substring(0,x_ind));

p=1;
int p_ind=s.indexOf("^");
if(p_ind!=-1) {
String pow=s.substring(p_ind+1,s.length());
p=Integer.parseInt(pow);
}
}Monom m=new Monom(c,p);

this.set_coefficient(m.get_coefficient());
this.set_power(m.get_power());}

//add to another  monom
public void add(Monom m) {
if(m.get_power()!=pow) {
throw new RuntimeException("The power is not the same");}
else
this.set_coefficient(m.get_coefficient()+this.get_coefficient());
}

//multipy  to another  monom
public Monom multipy(Monom d) {
Monom m=new Monom(this.base*d.get_coefficient(),this.pow+d.get_power());
return m;
}

public String toString() {
String ans = "";
if(this.get_power()<0)
ans="0";
if(this.isZero())
ans="0";
if(this.get_power()==0) {
ans+=this.get_coefficient();
}
else {


ans+=this.get_coefficient();
if(this.get_power()==1)
ans+="x";
if(this.get_power()>1) {
ans+="x^"+this.get_power();
}


}
return ans;
}
// you may (always) add other methods.

public void set_coefficient(double a){
this.base = a;
}

//****************** Private Methods and Data *****************


public void set_power(int p) {
if(p<0) {throw new RuntimeException("ERR the power of Monom should not be negative, got: "+p);}
this.pow
= p;
}

}




