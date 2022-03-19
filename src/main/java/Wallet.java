import java.util.Objects;

public class Wallet {

    private static double faceValue;
    private static CurrencyConverter currencyConverter;

    public Wallet() {
    }

    private Wallet(double faceValue, CurrencyConverter converter) {
        this.faceValue = faceValue;
        this.currencyConverter = converter;
    }

    public static Wallet Rupee(double faceValue) {
        return new Wallet(faceValue, currencyConverter.Rupee);
    }

    public static Wallet Dollar(double faceValue) {
        return new Wallet(faceValue, currencyConverter.Dollar);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;

        return Double.compare(this.currencyConverter.convertToDollar(faceValue, currencyConverter),
                              this.currencyConverter.convertToDollar(wallet.faceValue,wallet.currencyConverter)) == 0;
    }


    @Override
    public int hashCode() {
        return Objects.hash(faceValue, currencyConverter);
    }

    public static Wallet putMoney(Wallet tenDollar) {

        double finalValue = currencyConverter.convertInRequiredCurrency(faceValue,currencyConverter)+
                currencyConverter.convertInRequiredCurrency(tenDollar.faceValue,currencyConverter);

     return new Wallet(finalValue,currencyConverter);

    }
}
