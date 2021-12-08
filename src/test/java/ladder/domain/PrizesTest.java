package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.fail;

public class PrizesTest {
    private Names names;

    @BeforeEach
    public void setup() {
        names = new Names(Arrays.asList("aaa", "bbb", "ccc"));
    }

    @Test
    @DisplayName("참가자 수 와 상품 수 가 다르면 에러발생")
    public void validProductCount() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Prizes.of(Arrays.asList("꽝", "1000"), names);

            fail("상품 수 에러발생해야 한다.");
        });
    }

}
