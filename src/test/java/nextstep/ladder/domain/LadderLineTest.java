package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class LadderLineTest {
    @DisplayName("이름과 높이를 가지는 라인 생성")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void createLine(int height) {
        assertThatCode(() -> LadderLine.firstLine(new Person("dong"), height)).doesNotThrowAnyException();
    }

    @DisplayName("이전 라인의 상태에 따라 가로 라인을 만드는 라인 생성")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void createByPreviousLine(int height) {
        LadderLine first = LadderLine.firstLine(new Person("dong"), height);
        assertThatCode(
                () -> LadderLine.middleLine(new Person("chul"), first.getSteps())
        ).doesNotThrowAnyException();
    }
}
