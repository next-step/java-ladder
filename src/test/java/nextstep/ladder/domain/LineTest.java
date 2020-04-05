package nextstep.ladder.domain;

import nextstep.ladder.domain.step.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LineTest {
    @DisplayName("이름과 높이를 가지는 라인 생성")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void createLine(int height) {
        assertThatCode(() -> Line.first(new Person("dong"), height)).doesNotThrowAnyException();
    }

    @DisplayName("이전 라인의 상태에 따라 가로 라인을 만드는 라인 생성")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void createByPreviousLine(int height) {
        Line first = Line.first(new Person("dong"), height);
        assertThatCode(
                () -> Line.of(new Person("chul"), first.getSteps(), (previouSteps, bridge) -> Step.of(bridge, () -> true))
        ).doesNotThrowAnyException();
    }
}
