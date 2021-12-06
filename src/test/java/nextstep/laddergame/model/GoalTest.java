package nextstep.laddergame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GoalTest {

    @DisplayName("Goal의 value를 생성자로 주었을 때 그대로 생성하는지 검증")
    @Test
    void constructTest() {
        String value = "꽝";
        assertThat(new Goal(value).value()).isEqualTo(value);
    }
}
