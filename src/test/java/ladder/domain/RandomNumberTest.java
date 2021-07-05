package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class RandomNumberTest {

    @Test
    @DisplayName("RandomNumber로 사다리를 만들수 있는지 확인하는 테스트")
    void makableTest() {
        RandomNumber randomNumber = new RandomNumber();
        assertThat(randomNumber.installableLadder(5)).isEqualTo(true);
    }

    @Test
    @DisplayName("RandomNumber로 사다리를 만들수 없는지 확인하는 테스트")
    void makableTest2() {
        RandomNumber randomNumber = new RandomNumber();
        assertThat(randomNumber.installableLadder(1)).isEqualTo(false);
    }

}
