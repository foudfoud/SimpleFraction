public class Fraction extends Number implements Comparable<Fraction> {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fraction)) return false;
        Fraction f = (Fraction) o;
        return this.numerator * f.denominator == f.numerator * this.denominator;}

    @Override
    public int compareTo(Fraction f) {
        int left = this.numerator * f.denominator;
        int right = f.numerator * this.denominator;
        if (left < right) return -1;
        if (left > right) return 1;
        return 0;}

    @Override
    public int intValue() {return (int) doubleValue();}

    @Override
    public long longValue() {return (long) doubleValue();}

    @Override
    public float floatValue() {return (float) doubleValue();}
}
