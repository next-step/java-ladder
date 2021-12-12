package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class PrizeTest {
    @Test
    @DisplayName("상품은 빈값을 사용할수 없다.")
    public void productEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Prize("   ");

            fail("빈값 에러가 발생해야 한다.");
        });
    }
}
