public class Main {
    public static void main(String[] args) {

        // toString
        Fraction f = new Fraction();
        System.out.println(f.toString());
        assert f.toString().equals("Je suis une fraction.");

        // Constructeurs
        Fraction f1 = new Fraction(3, 4);
        Fraction f2 = new Fraction(5);
        Fraction f3 = new Fraction();
        assert f1.toString().equals("Je suis une fraction.");
        assert f2.toString().equals("Je suis une fraction.");
        assert f3.toString().equals("Je suis une fraction.");

        // Constantes ZERO et UN
        assert Fraction.ZERO.getNumerator() == 0 && Fraction.ZERO.getDenominator() == 1;
        assert Fraction.UN.getNumerator() == 1 && Fraction.UN.getDenominator() == 1;

        // Getters
        assert f1.getNumerator() == 3;
        assert f1.getDenominator() == 4;
        assert f2.getNumerator() == 5;
        assert f2.getDenominator() == 1;

        // doubleValue
        assert Math.abs(f1.doubleValue() - 0.75) < 1E-8;
        assert Math.abs(f2.doubleValue() - 5.0) < 1E-8;
        assert Math.abs(f3.doubleValue() - 0.0) < 1E-8;

        // add
        Fraction sum = new Fraction(1, 2).add(new Fraction(1, 3));
        assert Math.abs(sum.doubleValue() - (5.0 / 6.0)) < 1E-8;

        // equals
        assert new Fraction(1, 2).equals(new Fraction(2, 4));
        assert !new Fraction(1, 2).equals(new Fraction(1, 3));

        // compareTo
        assert new Fraction(1, 2).compareTo(new Fraction(1, 3)) > 0;
        assert new Fraction(1, 3).compareTo(new Fraction(1, 2)) < 0;
        assert new Fraction(1, 2).compareTo(new Fraction(2, 4)) == 0;

        // Héritage de Number
        Number aNumber = java.math.BigDecimal.ONE;
        Number anotherNumber = new Fraction(1, 2);
        assert Math.abs(aNumber.doubleValue() + anotherNumber.doubleValue() - 1.5) < 1E-8;

        System.out.println("Tous les tests sont passés.");
    }
}
