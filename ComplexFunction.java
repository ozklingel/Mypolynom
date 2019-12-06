package Ex1;

import java.rmi.server.Operation;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
/** class represents a complex function of type y=g(f1(x), f2(x)), where both f1, f2 are functions (or complex functions), 
 * y and x are real numbers and g is an operation: plus, mul, div, max, min, comp (f1(f2(x))).
**/
public class ComplexFunction implements complex_function {
	function left,right;
	Operation op;
	/**
	 * 
	 * defolt constractor
	 * so we use a multiply of Monom.
	 *  
	 */
	public ComplexFunction() {
		this.left=this.right=null;
		this.op=null;

	}
	/**
	 * init a  ComplexFunction from a String and 2 functions.
	 * a to right and b to left 
	 * 
	 *  
	 * @param s: is a string represents a ComplexFunction
	 */
	public ComplexFunction(String s,function a,function b) {
		for (int i = 0; i <7.; i++) {
			if s.equalsIgnoreCase(Operation.values().[i])
			this.op=Operation.values().[i];
		}
		this.left=a;
		this.right=b;

	}
	/**
	 * init a  ComplexFunction to empty ComplexFunction
	 * 
	 * 
	 *  
	 * @param s: is a string represents a ComplexFunction
	 */
	public ComplexFunction(function a) {
		this.op=Operation.None
				this.left=a;
	}

	/**
	 * init a  ComplexFunction from a String and 1 function .
	 * func a enter to the right
	 * 
	 *  
	 * @param s: is a string represents a ComplexFunction
	 */
	public ComplexFunction(String s,function a) {
		for (int i = 0; i <7.; i++) {
			if s.equalsIgnoreCase(Operation.values().[i])
			this.op=Operation.values().[i];
		}			
		this.left=a;
		this.right=null;

	}

	/**
	 * we replace a (double)x instead of 'x' in the Polynom
	 * so I use f(x) of Monom and POlynom.
	 * @return f(x)
	 */
	@Override
	public double f(double x) {
		double ans = 0;
		double l=this.left.f(x);
		double r=this.right.f(x);
		switch(this.op) {
		case (Operation.Plus){
			ans=r+l;
		}
		case (Operation.Comp){
			ans=this.right.f(this.left.f(x));
		}
		case (Operation.Min){
			if (l>r)
				ans=r;
			ans=l
		}

		case (Operation.Max){
			if (l<r)
				ans=r;
			ans=l
		}
		case ( Operation.Divid){
			ans=r/l;
		}
		case (Operation.Times){
			ans=r*l;
		}
		}
		return ans;	
		}

	@Override
	public function initFromString(String s) {
		function ans=new complexFunction();//holds the ans
		int psik_ind///find the psik index
		int firs_soger//find the op index+1
		for (int i = 0; i <7.; i++) {
			if s.substring(0, firs_soger-1).equalsIgnoreCase(Operation.values().[i])
			ans.op=Operation.values().[i];
		}			
		ans.left=initFromString( s.substring(firs_soger, psik_ind-1))
		ans.right=initFromString( s.substring(psik_ind+1, s.length()-1))
	}

	/**
	 
	 * We copy our ComplexFunction to cf: 
	 
	 * @return cf
	 */
	@Override
	public function copy() {

		ComplexFunction cf = new ComplexFunction(this.op, this.left,this.right);
		return cf;
	}
	/** Add to this complex_function the f1 complex_function
	 * 
	 * @param f1 the complex_function which will be added to this complex_function.
	 */
	@Override
	public void plus(function f1) {
		if(this.left==null) this.left = f1;
		if(this.right==null) this.right = f1;
		else if(this.right!=null){
			this.left = new ComplexFunction(this.op, this.left, this.right);
			this.right = f1;
		}
		this.op = Operation.Plus;
	}
	/** Multiply this complex_function with the f1 complex_function
	 * 
	 * @param f1 the complex_function which will be multiply be this complex_function.
	 */
	@Override
	public void mul(function f1) {
		if(this.left==null) this.left = f1;
		if(this.right==null) this.right = f1;
		else if(this.right!=null){
			this.left = new ComplexFunction(this.op, this.left, this.right);
			this.right = f1;
		}
		this.op = Operation.Times;
	}
}
/** Divides this complex_function with the f1 complex_function
 * 
 * @param f1 the complex_function which will be divid this complex_function.
 */
@Override
public void div(function f1) {
	if(this.left==null) this.left = f1;
	if(this.right==null) this.right = f1;
	else if(this.right!=null){
		this.left = new ComplexFunction(this.op, this.left, this.right);
		this.right = f1;
	}
	this.op = Operation.Divid;
}
}
/** Computes the maximum over this complex_function and the f1 complex_function
 * 
 * @param f1 the complex_function which will be compared with this complex_function - to compute the maximum.
 */
@Override
public void max(function f1) {
	if(this.left==null) this.left = f1;
	if(this.right==null) this.right = f1;
	else if(this.right!=null){
		this.left = new ComplexFunction(this.op, this.left, this.right);
		this.right = f1;
	}
	this.op = Operation.Max;
}

/** Computes the minimum over this complex_function and the f1 complex_function
 * 
 * @param f1 the complex_function which will be compared with this complex_function - to compute the minimum.
 */
@Override
public void min(function f1) {
	if(this.left==null) this.left = f1;
	if(this.right==null) this.right = f1;
	else if(this.right!=null){
		this.left = new ComplexFunction(this.op, this.left, this.right);
		this.right = f1;
	}
	this.op = Operation.Min;
}
/**
 * This method wrap the f1 complex_function with this function: this.f(f1(x))
 * @param f1 complex function
 */

@Override
public void comp(function f1) {
	if(this.left==null) this.left = f1;
	if(this.right==null) this.right = f1;
	else if(this.right!=null){
		this.left = new ComplexFunction(this.op, this.left, this.right);
		this.right = f1;
	}
	this.op = Operation.Comp;
}

/** returns the left side of the complex function - this side should always exists (should NOT be null).
 * @return a function representing the left side of this complex funcation
 */
@Override
public function left() {
	return this.left;
}
/** returns the right side of the complex function - this side might not exists (aka equals null).
 * @return a function representing the left side of this complex funcation
 */
@Override
public function right() {
	return this.right
}
/**
 * The complex_function oparation: plus, mul, div, max, min, comp
 * @return op
 */

@Override
public Operation getOp() {
	return this.op;
}




}
