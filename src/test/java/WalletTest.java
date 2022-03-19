
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


}
