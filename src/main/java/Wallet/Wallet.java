package Wallet;

import java.util.Objects;

public class Wallet {

    private final double faceValue;
    private final Currency currency;


    private Wallet(double faceValue, Currency currency) {
        this.faceValue = faceValue;
        this.currency = currency;
    }

    public static Wallet rupee(double faceValue) {
        return new Wallet(faceValue, Currency.Rupee);
    }

    public static Wallet dollar(double faceValue) {
        return new Wallet(faceValue, Currency.Dollar);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet otherCurrency = (Wallet) o;

        return Double.compare(Currency.convertToDollar(faceValue, currency), Currency.convertToDollar(otherCurrency.faceValue, otherCurrency.currency)) == 0;
    }


    public Wallet putMoney(Wallet tenDollar) {

        double faceValueOfCurrentObject = Currency.convertToDollar(faceValue, currency);
        double faceValueOfOtherObject = Currency.convertToDollar(tenDollar.faceValue, tenDollar.currency);

        double currentObjectInDesiredCurrency = currency.convertInRequiredCurrency(faceValueOfCurrentObject);
        double otherObjectInDesiredCurrency = currency.convertInRequiredCurrency(faceValueOfOtherObject);

        return new Wallet((currentObjectInDesiredCurrency + otherObjectInDesiredCurrency), currency);

    }


    public Wallet take(Wallet otherWalletObject) throws InSufficientException {

        double faceValueOfCurrentObject = Currency.convertToDollar(faceValue, currency);
        double faceValueOfOtherInDollar = Currency.convertToDollar(otherWalletObject.faceValue, otherWalletObject.currency);

        if (faceValueOfOtherInDollar > faceValueOfCurrentObject) throw new InSufficientException();

        double first = this.currency.convertInRequiredCurrency(faceValueOfCurrentObject);
        double second = this.currency.convertInRequiredCurrency(faceValueOfOtherInDollar);

        return new Wallet((first - second), currency);

    }


    @Override
    public int hashCode() {

        return Objects.hash(faceValue, currency);
    }

    @Override
    public String toString() {
        return "Wallet{" + "faceValue=" + faceValue + ", currencyConverter=" + currency + '}';
    }

}
