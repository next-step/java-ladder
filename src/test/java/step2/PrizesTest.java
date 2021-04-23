package step2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import step2.domain.Prize;
import step2.domain.Prizes;

public class PrizesTest {

    @Test
    void createPrize() {
        String[] input = {"꽝", "5000", "꽝", "3000"};
        Prizes prizes = new Prizes(String.join(",", input));
        List<Prize> prizeList = prizes.value();

        for (int i = 0; i < prizeList.size(); ++i) {
            assertEquals(input[i], prizeList.get(i).product().value());
        }
    }
}
