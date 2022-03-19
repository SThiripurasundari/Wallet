
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class WalletTest {

    @Test
    void  seventyFourPointEightFiveRupeesIsEqualToOneDollar() {

       Wallet SeventyFourPointEightFiveRupees =   Wallet.Rupee(74.85);
       Wallet oneDollar = Wallet.Dollar(1);

       assertThat(SeventyFourPointEightFiveRupees, is((equalTo(oneDollar))));
    }

    @Test
    void  oneDollarIsEqualToseventyFourPointEightFiveRupees() {

        Wallet SeventyFourPointEightFiveRupees =   Wallet.Rupee(74.85);
        Wallet oneDollar = Wallet.Dollar(1);

        assertThat(oneDollar, is((equalTo(SeventyFourPointEightFiveRupees))));
    }

    @Test
    void putMoneyInWallet() {

        Wallet fiveDollar = Wallet.Dollar(5);
        Wallet tenDollar = Wallet.Dollar(10);
        Wallet totalInDollar = fiveDollar.putMoney(tenDollar);

        Wallet fifteenDollar = Wallet.Dollar(15);

        assertThat(fifteenDollar,is(equalTo(totalInDollar)));
    }




}
