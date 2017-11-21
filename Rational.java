/***
Cheryl Qian
APCS pd2
HW#36 -- Be Rational
2017-11-20
***/


public class Rational {
    private int p, q;
    
    public Rational() {
	Rational init = new Rational(0,1);
    }
    
    public Rational(int num, int denom) {
	p = num;
	q = denom;
	if ( q == 0 ) {
	    System.out.println("Error: Cannot divide by 0");
	    p = 0;
	    q = 1;
	}
    }

    public double floatValue() {
	return (double) p/q;
    }

    public void multiply(Rational r) {
	p *= r.p;
	q *= r.q;
    }

    public void divide(Rational r) {
	Rational inv = new Rational(r.q, r.p);
	this.multiply(inv);	
    }

    public static int numGcd(int a, int b) {
	if (a == 0)
	    return b;

	while (b != 0) {
	    if (a > b)
		a = a - b;
	    else
		b = b - a;
	}

	return a;
    }

    public int gcd() {
	return numGcd(p, q);
    }

    public void reduce() {
	int g = gcd();
	p /= g;
	q /= g;
    }

    public void add( Rational r ) {
	int a = p * r.q;
	int b = r.p * q;
	p = a + b;
	q = r.q * q;
    }

    public void subtract( Rational r ) {
	int a = p * r.q;
	int b = r.p * q;
	p = a - b;
	q = r.q * q;
    }

    public double compareTo( Rational r ) {
        double a = floatValue();
	double b = r.floatValue();
	return a - b;
    }
	

    public String toString() {
	return "Fractional: " + p + "/" + q + "\nEvaluated: " + floatValue() + "\n";
    }
    
    public static void main(String[] args) {
	Rational a = new Rational(2,3);
	
	System.out.println(a);//0.6666
	
	Rational b = new Rational(3,4);
	
	System.out.println(a);//0.6666
	System.out.println(b);//0.75
	
	a.multiply(b);
	
	System.out.println(a);//0.5
	System.out.println(b);//0.75
	
	a.add(b);
	
	System.out.println(a);//1.25
	System.out.println(b);//0.75
	
	a.divide(b);
	
	System.out.println(a);//0.666
	System.out.println(b);//0.75
	
	Rational n = new Rational(4,5);
	Rational q = new Rational(2,5);
	
	n.subtract(q);
	System.out.println(n);//0.4
	System.out.println(q);//0.4
	
	Rational s = new Rational(286,350);
	
	s.reduce();

	System.out.println(s);
	
	System.out.println(n.compareTo(q));
	System.out.println(n.compareTo(s));
	System.out.println(s.compareTo(n));
    }
}
