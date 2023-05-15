package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import ladder.util.RandomPointStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderHeightTest {

    @Test
    @DisplayName("1 이상의 값이 입력된 경우 정상 사다리 객체를 생성한다.")
    void objCreateTest() {
        assertDoesNotThrow(() -> new LadderHeight(1));
    }

    @Test
    @DisplayName("0 이하의 값이 입력된 경우 익셉션을 발생시킨다.")
    void toLowExceptionTest() {
        assertThatThrownBy(() -> new LadderHeight(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 1 이상이여야 합니다.");
    }

    @Test
    @DisplayName("참가자와 사다리 높이에 맞춰 사다리 전체를 생성한다")
    void createLinesTest() {
        assertThat(new LadderHeight(5).linesByHeight(5, new RandomPointStrategy()).size())
                .isEqualTo(5);
    }
}
