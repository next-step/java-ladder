package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("전체 플레이어 수와 높이를 입력받아 Ladder 객체를 생성한다.")
    @Test
    void test() {
        Ladder ladder = new Ladder(4, 5);
        assertThat(ladder).isNotNull();
    }
}
