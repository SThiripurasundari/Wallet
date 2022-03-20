package Wallet;

import java.text.DecimalFormat;

public enum Currency {
    Rupee(74.85),
    Dollar(1);

    private final double currency;
    static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    Currency(double currency) {
        this.currency = currency;
    }

    public static double convertToDollar(double faceValue, Currency currencyConverter) {
        return roundedDouble(faceValue / currencyConverter.currency);
    }

    public double convertInRequiredCurrency(double faceValue) {
        return roundedDouble(faceValue * currency);
    }

    private static double roundedDouble(double inputDouble) {
        return Double.parseDouble(DECIMAL_FORMAT.format(inputDouble));
    }

}
