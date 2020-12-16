public class Rational
{
    // instance variables: every Rational object will have its own copy
    // of these variables
    public int numerator;
    public int denominator;
    
    /**
     * Constructor: the special method that will actually create a new Rational
     * object
     * Constructors are always public
     * Constructors have the same name as the class
     * Constructors have no return type
     */
    public Rational(int a, int b)
    {
        numerator = a;
        denominator = b;
    }
    
    // This method takes two Rationals, add thems up, 
    // and returns a Rational equal to the sum
    public static Rational add(Rational r, Rational s)
    {
        int newNumerator = r.numerator*s.denominator + s.numerator*r.denominator;
        int newDenominator = r.denominator*s.denominator; 
        
        Rational x = new Rational(newNumerator, newDenominator);
        return Rational.simplify(x);
    }

    // Finds the greatest common factor between a and b
    public static int greatestCommonFactor(int a, int b){
        int gcd = 1;

        int k = Math.max(a, b);
        
        for(int i = 1; i <= k; i ++){
            if (a%i == 0 && b%i == 0){
                gcd = i;
            }
        }

        return gcd;
    }
    public static int lcm(int a, int b){
        int lcm = 1;

        int k = Math.min(a, b);
        
        for(int i = 1; i <= k; i ++){
            if (a%i == 0 && b%i == 0){
                lcm = i;
            }
        }

        return lcm;
    }

    // This method is given a rational, and returns a simplified version
    // of the input rational
    // e.g. simplify(2/4) => 1/2
    //      simplify(1/2) => 1/2
    public static Rational simplify(Rational r)
    {
        int gcf = greatestCommonFactor(r.numerator, r.denominator);
        int new_num = r.numerator/gcf;
        int new_denom = r.denominator/gcf;
        Rational x = new Rational(new_num, new_denom);
        return x;
    }

    // This method takes two Rationals, subtracts thems up, 
    // and returns a Rational equal to the difference
    public static Rational subtract(Rational r, Rational s)
    {
        int l_c = lcm(s.denominator, r.denominator);
        int min_dem = Math.min(r.denominator, s.denominator);
        int new_num = 0;
        int new_dem = 0;
        if(min_dem == r.denominator){
            new_num = r.numerator * l_c;
            new_dem = r.numerator * l_c;
        }
        if(min_dem == s.denominator){
            new_num = s.numerator * l_c;
            new_dem = s.numerator * l_c;
        }
        Rational x = new Rational(new_num, new_dem);
        return Rational.simplify(x);
    }
    
    public static Rational multiply(Rational r, Rational s)
    {
        int new_num = r.numerator * s.numerator;
        int new_dem = r.denominator * s.denominator;
        Rational x = new Rational(new_num, new_dem);
        return Rational.simplify(x);
    }
    
    public static Rational divide(Rational r, Rational s)
    {
        int new_num = r.numerator * s.denominator;
        int new_dem = r.denominator * s.numerator;
        Rational x = new Rational(new_num, new_dem);
        return Rational.simplify(x);
    }

    public boolean isNegative()
    {
        double result = (double) this.numerator/this.denominator;
        if(result < 0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean equals(Rational r){
        Rational result_r = Rational.simplify(r);
        Rational result_this = Rational.simplify(this);
        if(result_r.numerator == result_this.numerator && result_r.denominator == result_this.denominator){
            return true;
        }
        else{
            return false;
        }
    }
    //Stuff from classwork
    public Rational reciprocal(){
        Rational recip = new Rational(this.denominator, this.numerator);
        return recip;
    }

    // These following methods are NOT static, we'll talk about them next class!
    // This returns a string representation of a Rational (e.g. "1/2")
    @Override
    public String toString()
    {
        return this.numerator + "/" + this.denominator;
    }
// isSimplified(): returns whether or not the Rational is simplified
    public boolean isSimplified(){
        Rational r = Rational.simplify(this);
        if(r.numerator == this.numerator && r.denominator == this.denominator){
            return true;
        }
        else{
            return false;
        }
    }
// calculateDecimalValue(): returns the decimal value of some Rational object (e.g. 1/2 => 0.5)
    public double calculateDecimalValue(){
        double result = (double)this.numerator / this.denominator;
        return result;
    }
// pow(): returns the fraction we get from raising the rational number to an integer power
    public Rational pow(int e){
        int numerator = (int) Math.pow(this.numerator, e);
        int denominator = (int) Math.pow(this.denominator, e);

        return new Rational(numerator, denominator);
    }
// matches():checks to see if either the numerator or denominator match a given number
    public boolean matches(int g){
        if(this.numerator == g || this.denominator == g){
            return true;
        }
        return false;
    }
    public Rational add(Rational s)
    {
        // REPLACE WITH YOUR CODE HERE
        return null;
    }
    
    public Rational subtract(Rational s)
    {
        // REPLACE WITH YOUR CODE HERE
        return null;
    }
    
    public Rational multiply(Rational s)
    {
        // REPLACE WITH YOUR CODE HERE
        return null;
    }
    
    
    public Rational divide(Rational s)
    {
        // REPLACE WITH YOUR CODE HERE
        return null;
    }
}













