/**
 * 
 * @author Jason Wang
 * @version 1.0
 * @since 2022-11-20
 * 
 *
 */
		
	/**
	 * 
	 * Default constructor that creates a fraction with numerator of 1 and denominator of 1
	 *
	 */
	public class Fraction {
	private int numerator;
	private int denominator;
	public Fraction() {
		numerator=1;
		denominator=1;
	}
	/**
	 * Postcondition
	 * 			If denominator entered is 0, the constructor automatically change it to 1 instead.
	 * @param num Numerator of the fraction 
	 * @param den Denominator of the fraction
	 */
	public Fraction(int num, int den) {
		numerator=num;
		setDen(den);
	}
	/**
	 * Preconditions:
	 * 			the string parameter is not null nor empty
	 * 			it is in the format of numerator/denominator
	 * 			contains "/"
	 * Postconditions:
	 * 			If the numeric denominator string value is 0, the constructor automatically set it to 1 instead;
	 * @param str A String that written in fraction form
	 */
	public Fraction(String str) {
		String[] list=str.split("/");
		numerator=Integer.parseInt(list[0]);
		setDen(Integer.parseInt(list[1]));
	}
	/**
	 * 
	 * 			
	 * @param frac A fraction object 
	 */
	public Fraction(Fraction frac) {
		numerator=frac.numerator;
		denominator=frac.denominator;
	}
	/**
	 * 
	 * @return int The numerator of this fraction object
	 */
	public int getNum() {
		return (numerator);
	}
	/**
	 * 
	 * @return int The denominator of this fraction object
	 */
	public int getDen() {
		return (denominator);
	}
	/**
	 * 
	 * @param n An integer value that user wan to set as the numerator of this fraction
	 */
	public void setNum(int n) {
		numerator=n;
	}
	/**
	 * Postconditions:
	 * 			If denominator is set as 0; it automatically changes to 1 instead
	 * @param d An integer value that user wan to set as the numerator of this fraction
	 */
	public void setDen(int d) {
		if(d!=0)
			denominator=d;
		else {
			denominator=1;
			System.out.println("Error: denominator can not be 0, I changed it to 1");
		}
	}
	/**
	 * 
	 * @return double This fraction in decimal format
	 */
	public double toDecimal() {
		return ((double)numerator/denominator);
	}
	/**
	 * It looks for the greatest common factors of the two designated number
	 * 
	 * @param n1 the first number for the greatest common factor method
	 * @param n2 the second number for the greatest common factor method
	 * @return int The greatest common factor of the two number
	 */
	private int GCF(int n1, int n2) {
		int rem=Math.max(n1, n2)%Math.min(n1, n2);
		if(rem!=0)
			return (GCF(Math.min(n1, n2),rem));
		else 
			return (Math.min(n1, n2));
	}
	/**
	 * simplifies the fraction
	 */
	public void reduce() {
		int gcf=GCF(denominator, numerator);
		denominator/=gcf;
		numerator/=gcf;
		if(denominator<0&&numerator<0) {
			denominator= -denominator;
			numerator=  -numerator;
		}
	}
	/**
	 * 
	 * @param frac The fraction which is taking its reciprocal
	 * @return Fraction The reciprocal of the passed in fraction
	 */
	private static Fraction reciprocal(Fraction frac) {
		return new Fraction(frac.denominator, frac.numerator);
	}
	/**
	 * Postconditions:
	 * 			Expressed in the lowest term.
	 * @param frac1 The first fraction is being added
	 * @param frac2	The second fraction is being added
	 * @return Fraction The sum of the two fractions
	 */
	public static Fraction add(Fraction frac1, Fraction frac2) {
		Fraction result = new Fraction(frac1.numerator*frac2.denominator+frac2.numerator*frac1.denominator, frac1.denominator*frac2.denominator);
		result.reduce();
		return result;
	}
	/**
	 * Postconditions:
	 * 			Expressed in the lowest term.
	 * @param frac The fraction that is being added by another fraction object
	 * @return Fraction The sum of the two fractions
	 */
	public Fraction add(Fraction frac) {
		Fraction result = new Fraction(numerator*frac.denominator+frac.numerator*denominator, denominator*frac.denominator);
		result.reduce();
		return result;
	}
	/**
	 * Postconditions:
	 * 			Expressed in the lowest term.
	 * @param frac1 The subtracting fraction 
	 * @param frac2 The fraction that is subtracted from frac1
	 * @return Fraction The difference of the two fractions
	 */
	public static Fraction substract(Fraction frac1, Fraction frac2) {
		Fraction result = new Fraction(frac1.numerator*frac2.denominator-frac2.numerator*frac1.denominator, frac1.denominator*frac2.denominator);
		result.reduce();
		return result;
	}
	/**
	 * Postconditions:
	 * 			Expressed in the lowest term.
	 * @param frac The fraction that is subtracted from the other fraction object
	 * @return Fraction The difference of the two fractions
	 */
	public Fraction substract(Fraction frac) {
		Fraction result = new Fraction(numerator*frac.denominator-frac.numerator*denominator, denominator*frac.denominator);
		result.reduce();
		return result;
	}
	/**
	 * Postconditions:
	 * 			Expressed in the lowest term.
	 * @param frac1 The first fraction that is being multiplied
	 * @param frac2 The second fraction that is being multiplied
	 * @return Fraction The product of the two fractions
	 */
	public static Fraction multiply(Fraction frac1, Fraction frac2) {
		Fraction result = new Fraction(frac1.numerator*frac2.numerator, frac1.denominator*frac2.denominator);
		result.reduce();
		return result;
	}
	/**
	 * Postconditions:
	 * 			Expressed in the lowest term.
	 * @param frac The fraction that is being multiplied by the other fraction object
	 * @return Fraction The product of the two fractions
	 */
	public Fraction multiply(Fraction frac) {
		Fraction result = new Fraction(numerator*frac.numerator, denominator*frac.denominator);
		result.reduce();
		return result;
	}
	/**
	 * Postconditions:
	 * 			If it is dividing by 0, returns null and error message.
	 * 			Expressed in the lowest term.
	 * @param frac1 The first fraction that is getting divided by
	 * @param frac2 The second fraction that is dividing
	 * @return Fraction The ratio or the quotient of the two fractions
	 */
	public static Fraction divide(Fraction frac1, Fraction frac2) {
		if(frac2.toDecimal()==0) {
			System.out.println("You can not divided by 0");
			return null;
		}
		return Fraction.multiply(frac1, reciprocal(frac2));
	}
	/**
	 * Postconditions:
	 * 			If it is dividing by 0, returns null and error message.
	 * 			Expressed in the lowest term.
	 * @param frac The fraction that is dividing
	 * @return Fraction The ratio or the quotient of the two fractions
	 */
	public Fraction divide(Fraction frac) {
		if(frac.toDecimal()==0) {
			System.out.println("You can not divided by 0");
			return null;
		}
		return Fraction.multiply(new Fraction(numerator, denominator), reciprocal(frac));
	}
	/**
	 * 
	 * Prints the fraction object
	 * @return String The string value of numerator and denominator separated by "/" 
	 */
	public String toString() {
		String result="";
		result+=numerator+"/"+denominator;
		return result;
	}
}
