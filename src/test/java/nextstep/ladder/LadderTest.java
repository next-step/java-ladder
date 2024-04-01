package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("Ladder 객체를 초기화했을 때, 입력한 사다리 높이에 따라 Line 객체가 생성된다")
    @Test
    void ladder() {
        assertThat(new Ladder(5, 3).getLines().size()).isEqualTo(5);
    }

}
