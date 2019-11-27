
package myMath;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply and more comlicated methods
 * i used arraylist to implement this object.
 */
public class Polynom implements Polynom_able{

private   ArrayList<Monom> poly=new ArrayList<Monom>();
private Iterator<Monom> polyit=poly.iterator();
public Polynom() {
this.poly=new ArrayList<Monom>();//pointer to start(null)

}

public Polynom(String s) {//Polynom string constructor , splitting the string into sub string and put every sub string in array, then every substring could be an monom . then we move to monom class functions .
if(s.length()==0)//checking if the string is empty
throw  new RuntimeException("Error : polynom can't be Empty ");
///change sighs for make it easier
String ans="";

s=s.replaceAll("-", "+-");

s=s.replaceAll(" ", "");


//spilling by +
String[] spl=s.split("+");

for (int i = 0; i < spl.length; i++) {
if(spl[i].equals(""))continue;
String re=spl[i];
Monom m=new Monom(re);
poly.add(m);
Collections.sort(poly,new Monom_Comperator());
}



}

public Polynom(Monom m) {//Polynom constructor that create a polynom with a only one monom
	Polynom p=new Polynom();
	p.poly=this.poly;
	if(!p.poly.isEmpty()) {
	p.poly.add(m);
	Collections.sort(poly,new Monom_Comperator());

	}else
	p.poly.add(m);

	}


public Iterator<Monom> iteretor() {
return poly.iterator();
}
public ArrayList<Monom> getPoly(){
return this.poly;
}


@Override
public void add(Polynom_able p1) {//this will add an polynom to our polynom , by  add every monomin given poly to our polynom .


Iterator<Monom> It = p1.iteretor() ;

Monom temp=new Monom(0,0);
while(It.hasNext()){
temp=It.next();
this.add(temp);
}
Polynom cop=(Polynom)this;



this.poly=cop.poly;

Collections.sort(poly,new Monom_Comperator());

}








@Override
public void add(Monom m1) {// add an monom to our polynom , take every 2 monoms whith same pow and add them
	Iterator<Monom> it=this.iteretor();
	boolean itover=false;
	while(it.hasNext()) {
	Monom m0=it.next();
	boolean flag=(m1.get_power()==m0.get_power());//isit the same pow of Monoms
	if(flag) {
	m0.set_coefficient(m0.get_coefficient()+m1.get_coefficient());
	itover=true;
	}

	
	}

	if(itover==false)
	this.poly.add(m1);

	
	}

	


@Override
public double f(double x) {//culculate the f(x) of every monom and sum them
double ans=0;
Iterator<Monom> it=this.iteretor();

while(it.hasNext()) {
Monom m=it.next();
ans+=m.f(x);


}
return ans;//the result of the sum of monoms(f(x))

}

@Override
public void substract(Polynom_able p1) {// substract monom from our polynom

//this will make the monom be negative
	Polynom p=new Polynom();

	p=(Polynom)p1;

	Polynom m = new Polynom();

	m.add(new Monom(-1,0));

	p1.multiply(m);

	this.add(p1);



}
@Override
public void multiply(Monom m1) {
	// TODO Auto-generated method stub

	Polynom ans=new Polynom();//answer
	
///sort for have sorted power
	
	Iterator<Monom> it=this.iteretor();

	while(it.hasNext()) {
		Monom m=it.next(); 
		for (int i = 0; i <this.poly.size(); i++) {
			Monom mu=new Monom(m.multipy(this.poly.get(i)));
			ans.add(mu);}
}

	this.poly=ans.poly;

}




	

@Override

public void multiply(Polynom_able p1) {//this will multply our poly with giving poly by moving with iterator and for loop . one can move on the giving poly and the other loop for our poly and multply every monom by the other poly

	Polynom ans=new Polynom();//answer
	Polynom p2=new Polynom();//copy to work on
	p2=(Polynom)p1;
///sort for have sorted power
	Collections.sort(p2.poly,new Monom_Comperator());
	Iterator<Monom> it=p2.iteretor();

	while(it.hasNext()) {
		Monom m=it.next(); 
		for (int i = 0; i <this.poly.size(); i++) {
			Monom mu=new Monom(m.multipy(this.poly.get(i)));
			ans.add(mu);}
}

	this.poly=ans.poly;

}


@Override
public boolean equals(Polynom_able p1)
{//here we can check if the giving polynom is equal to our polynom by using 2 iterators and checking every monom if equal to the other one .
	
	
	
	while(p1.iteretor().hasNext()) {
		Monom m1=p1.iteretor().next();
		Monom m2=this.poly.iterator().next();
		if((m1.get_power()!=m2.get_power())||m1.get_coefficient()!=m2.get_coefficient())
			return false;
	}
	return true;


}


@Override
public boolean isZero() {//this will check if our poly is zero by moving using iteratoz on or monom and check if our monom coefficient isn't zero then return true if nothing found .
Iterator<Monom> it=this.poly.iterator();
int zero=0;

while(it.hasNext()) {
    Monom m=it.next();

if(m.get_coefficient()!=zero)
	//which means it a non zero monom
             return false;
}



return true;
}



@Override
public double root(double x0, double x1, double eps) //root function will give us root of our poly by entring 2 points and eps . so we will check on every iteration the mid and take the negative side then returning the mid when the mid became < from eps
{

if(this.f(x0)>=0&&this.f(x1)>=0||f(x0)<=0&&this.f(x1)<=0) {
	throw  new RuntimeException("Error : there is no root ");


}
double ans=x1;
while((x1-x0)>=eps) {
	
	ans=(x1+x0)/2;
if(this.f(ans)!=0.0) {
	if (this.f(ans)*this.f(x0)<0)
		x1=ans;
		    else
		x0=ans;}

///this is the root
else 
	break;
}

return ans;
}

@Override
public Polynom_able copy() {// this will copy our poly by moving on our poly using iterator and adding it to a new polynom .

	
	Polynom_able ans=new Polynom();
Iterator<Monom> it=this.poly.iterator();

while(it.hasNext()){
Monom m=it.next();
///add this monom to the polinom
ans.add(m);
}

return ans;

}

@Override
public Polynom_able derivative() {//this will derivative the poly by moving on every monom in the poly and derivate it using the monom func
	Iterator<Monom> itt=this.poly.iterator();
	while(itt.hasNext()) {
		Monom mm=itt.next();
		if (mm.get_power()==0) {
			mm.set_coefficient(1);
			mm.set_power(0);
		}
		

	}
Polynom ans=new Polynom();
	
Iterator<Monom> it=this.poly.iterator();

while(it.hasNext()) {
Monom m=it.next();
m.derivative();
ans.add(m);

}

return ans;


}
/* Compute Riemann's Integral over this Polynom starting from x0, till x1 using eps size steps,
* see: https://en.wikipedia.org/wiki/Riemann_integral
* @return the approximated area above the x-axis below this Polynom and between the [x0,x1] range.
*/
@Override
public double area(double x0, double x1, double eps) {
	
double ans=0;

double hi;
double kta;//how many ktaim of x
int i;//run on the Monoms
for( kta = x0; kta<x1; kta+=eps) {
for( i = 0; i<this.poly.size(); i++) {
double Y = kta+(eps/2);
Monom m=this.poly.get(i);
hi = m.f(Y);
ans += (hi*eps);
}
}
return ans;

}

// ********** add your code below ***********





public String toString() {
for (int i = 0; i <poly.size(); i++) {
	Monom m=this.poly.get(i);
if(m.get_coefficient()==0)
poly.remove(i);

}
String res=null;
Polynom p=new Polynom();
p.poly=this.poly;
boolean f=true;
if(p.isZero())
return "0";
Iterator<Monom> it=p.iteretor();
while(it.hasNext()) {
Monom m=it.next();
if(res==null) {
res=""+m.toString();
}
else res+="+"+m.toString();
}
return res;
}







}