import static Wallet.Wallet.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import Wallet.Wallet;
import org.junit.jupiter.api.Test;
import Wallet.InSufficientException;


public class WalletTest {

    @Test
    void seventyFourPointEightFiveRupeesIsEqualToOneDollar() {

        Wallet SeventyFourPointEightFiveRupees = rupee(74.85);
        Wallet oneDollar = dollar(1);

        assertThat(SeventyFourPointEightFiveRupees, is((equalTo(oneDollar))));
    }

    @Test
    void oneDollarIsEqualToSeventyFourPointEightFiveRupees() {

        Wallet SeventyFourPointEightFiveRupees = rupee(74.85);
        Wallet oneDollar = dollar(1);

        assertThat(oneDollar, is((equalTo(SeventyFourPointEightFiveRupees))));
    }

    @Test
    void putMoneyInWalletInDollars() {

        Wallet fiveDollar = dollar(5);
        Wallet tenDollarInWallet = dollar(10);
        Wallet fifteenDollar = dollar(15);

        Wallet totalDollarsInWallet = tenDollarInWallet.put(fiveDollar);

        assertThat(totalDollarsInWallet, is((equalTo(fifteenDollar))));
    }


    @Test
    void putMoneyInWalletInRupees() {

        Wallet fiveRupeesInWallet = rupee(5);
        Wallet tenRupees = rupee(10);
        Wallet fifteenRupees = rupee(15);

        Wallet totalRupeesInWallet = fiveRupeesInWallet.put(tenRupees);

        assertThat(totalRupeesInWallet, is(equalTo(fifteenRupees)));
    }


    @Test
    void takeMoneyOutOfWalletInRupees() throws InSufficientException {

        Wallet twentyRupees = rupee(20);
        Wallet fiveRupees = rupee(5);
        Wallet fifteenRupees = rupee(15);

        Wallet walletBalanceFifteenRupees = twentyRupees.take(fiveRupees);

        assertThat(walletBalanceFifteenRupees, is((equalTo(fifteenRupees))));
    }

    @Test
    void takeMoneyOutOfWallet() throws InSufficientException {

        Wallet sevenHundredFortyEightPointFive = rupee(748.5);
        Wallet oneDollar = dollar(1);
        Wallet sixHundredSeventyThreePointSixtyFive = rupee(673.65);

        Wallet walletBalanceInRupees = sevenHundredFortyEightPointFive.take(oneDollar);

        assertThat(walletBalanceInRupees, is((equalTo(sixHundredSeventyThreePointSixtyFive))));
    }

    @Test
    void totalWalletMoneyInRupeesAsPreferredCurrency() {

        Wallet fiftyRupees = rupee(50);
        Wallet oneDollar = dollar(1);
        Wallet totalWalletMoneyInRupees = fiftyRupees.put(oneDollar);

        Wallet hundredTwentyFourPointEightFive = rupee(124.85);

        assertThat(totalWalletMoneyInRupees, is((equalTo(hundredTwentyFourPointEightFive))));
    }

    @Test
    void totalWalletMoneyInDollarAsPreferredCurrency() {

        Wallet oneDollar = dollar(1);
        Wallet seventyFourPointEightyFiveRupees = rupee(74.85);
        Wallet hundredFortyNinePointSevenRupees = rupee(149.7);
        Wallet fourDollar = dollar(4);

        Wallet totalWalletMoneyInDollars = oneDollar.put(seventyFourPointEightyFiveRupees).
                put(hundredFortyNinePointSevenRupees);

        assertThat(totalWalletMoneyInDollars, is(equalTo(fourDollar)));
    }

    @Test
    void inSufficientAmountException() {

        Wallet fiveRupees = rupee(5);
        Wallet twentyRupees = rupee(20);

        assertThrowsExactly(InSufficientException.class, () -> fiveRupees.take(twentyRupees));
    }

    @Test
    void inSufficientAmountExceptionForMixedCurrency() {

        Wallet fiveRupees = rupee(5);
        Wallet oneDollar = dollar(1);

        assertThrowsExactly(InSufficientException.class, () -> fiveRupees.take(oneDollar));
    }
}
