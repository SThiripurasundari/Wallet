import java.text.DecimalFormat;

public enum CurrencyConverter {
    Rupee(74.85),
    Dollar(1);

    private double currency;
    static DecimalFormat df = new DecimalFormat("#.##");

    CurrencyConverter(double currency) {
        this.currency = currency;
    }

    public static double convertToDollar(double faceValue, CurrencyConverter currencyConverter) {
        return roundedDouble(faceValue / currencyConverter.currency);
    }

    private static double roundedDouble(double inputDouble) {
        System.out.println("in Converter :"+Double.parseDouble(df.format(inputDouble)));
        return Double.parseDouble(df.format(inputDouble));
    }

}