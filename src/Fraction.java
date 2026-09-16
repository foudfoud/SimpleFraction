public class Fraction {

    private int numerator;
    private int denominator;

    public static final Fraction ZERO = new Fraction(0, 1);
    public static final Fraction UN = new Fraction(1, 1);

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;}

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;}

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;}

    public int getNumerator() {return numerator;}
    public int getDenominator() {return denominator;}

    @Override
    public String toString() {
        return "Je suis une fraction.";}

    public double doubleValue() {return (double) numerator / denominator;}
    public Fraction add(Fraction f) {
    int num = this.numerator * f.denominator + f.numerator * this.denominator;
    int den = this.denominator * f.denominator;
    return new Fraction(num, den);}

}
