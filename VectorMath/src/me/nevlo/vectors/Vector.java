package me.nevlo.vectors;

import java.io.OutputStream;
import java.io.PrintStream;

public class Vector {
	private double x,y,z;
	public double getX() { return x; }
	public double getY() { return y; }
	public double getZ() { return z; }
	
	///////////////////////////////////////////////////////////
	///////////////////// CONSTRUCTORS ////////////////////////
	///////////////////////////////////////////////////////////
	public Vector() {
		x = 0; y = 0 ; z = 0;
	}
	
	
	public Vector(double x, double y){
		this.x = x;
		this.y = y;
		z = 0;
	}
	public Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Vector(Vector o) {
		x = o.getX();
		y = o.getY();
		z = o.getZ();
		
	}
	///////////////////////////////////////////////////////////
	////////////////// GETTERS AND SETTERS ////////////////////
	///////////////////////////////////////////////////////////
	public double getMagnitude() {
		return Math.sqrt(x*x + y*y + z*z);
	}
	public double getTheta() {
		double theta = 0;
		if(Math.abs(x) == x) {
			if(Math.abs(y)== y) {
				theta = Math.atan(y/x);
			}else {
				theta = Math.atan(y/x) + 2 * Math.PI;
			}
		}else {
			theta = Math.atan(y/x) + Math.PI;
		}
		return theta;
	}
	public void setTheta(double theta)  {
		double mag = this.getMagnitude();
		x = Math.floor(mag * Math.cos(theta));
		y = Math.floor(mag * Math.sin(theta));
	
	}
	public void setMagnitude(double mag) {
		
		double theta = this.getTheta();
		x = Math.floor(mag * Math.cos(theta));
		y = Math.floor(mag * Math.sin(theta));
		
	}
	public Vector getUnitVector() {
		Vector unit = new Vector(this);
		unit.x = x/getMagnitude();
		unit.y = y/getMagnitude();
		unit.z = z/getMagnitude();
		return unit;
	}
	
	
	
	
	public void printVector(OutputStream s) {
		if(s == System.out) {
			((PrintStream) s).println("X: " + x + " Y: " + y + " Z: " + z);
			((PrintStream) s).println("Magnitude: " + getMagnitude() + " Theta: " + getTheta());
		}
	}
	
	///////////////////////////////////////////////////////
	////////////////////////MATH///////////////////////////
	///////////////////////////////////////////////////////
	
	
	public Vector add(Vector a, Vector b) {
		Vector v = new Vector();
		v.x = a.x + b.x;
		v.y = a.y + b.y;
		v.z = a.z + b.z;
		return v;
	}
	public void add(Vector b) {
		x += b.x;
		y += b.y;
		z += b.z;
	}
	public Vector subtract(Vector a, Vector b) {
		Vector v = new Vector();
		v.x = a.x - b.x;
		v.y = a.y - b.y;
		v.z = a.z - b.z;
		return v;
	}
	public void subtract(Vector b) {
		x -= b.x;
		y -= b.y;
		z -= b.z;
	}
}
