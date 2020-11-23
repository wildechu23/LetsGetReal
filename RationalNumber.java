public class RationalNumber extends RealNumber
{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *  If the denominator is negative, negate both numerator and denominator
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0.0);//this value is ignored! 
    if(deno == 0 ){
      numerator = 0;
      denominator = 1;
    } else if(deno < 0) {
      numerator = -nume;
      denominator = -deno;
    } else {
      numerator = nume;
      denominator = deno;
    }
    reduce();
  }

  public double getValue(){
    return (double)numerator/denominator;
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    return new RationalNumber(denominator, numerator);
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return numerator == other.getNumerator() && denominator == other.getDenominator();
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    return numerator + "/" + denominator;
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    /*use euclids method or a better one
    http://sites.math.rutgers.edu/~greenfie/gs2004/euclid.html */
    int p = Math.abs(a);
    int q = Math.abs(b);
    if(p < q) {
      int hold = q;
      q = p;
      p = hold;
    }
    if(q == 0) {
      return p;
    }
    if (p % q == 0) {
      return q;
    }
    if(gcd(q, p % q) > 0 || p % q == 0) {
      return gcd(q, p % q);
    }
    return -1;
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int divisor = gcd(getNumerator(), getDenominator());
    System.out.println("Divisor is " + divisor);
    numerator /= divisor;
    denominator /= divisor;
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    return new RationalNumber(getNumerator() * other.getNumerator()
    ,getDenominator() * other.getDenominator());
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    return new RationalNumber(getNumerator() * other.getDenominator(), getDenominator() * other.getNumerator());
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    return new RationalNumber(
      getNumerator() * other.getDenominator() + getDenominator() * other.getNumerator(),
      getDenominator() * other.getDenominator());
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    return new RationalNumber(getNumerator() * other.getDenominator() - getDenominator() * other.getNumerator(),
        getDenominator() * other.getDenominator());
  }
}
