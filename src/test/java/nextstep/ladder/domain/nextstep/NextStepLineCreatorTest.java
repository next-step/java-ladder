package nextstep.ladder.domain.nextstep;

import nextstep.ladder.domain.engine.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NextStepLineCreatorTest {

    private NextStepLineCreator lineCreator;

    @BeforeEach
    void setUp() {
        this.lineCreator = new NextStepLineCreator();
    }

    @DisplayName("width 만큼 사다리를 생성 했을 때, width 보다 큰 값을 조회하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void name(int value) {
        int width = 5;

        Line line = lineCreator.create(width, () -> true);

        assertThatThrownBy(() -> line.move(width + value))
                .isInstanceOf(Exception.class);
    }

    @DisplayName("width 만큼 사다리를 생성 했을 때, 0 ~ width 값을 조회하면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void name1(int value) {
        int width = 5;

        Line line = lineCreator.create(width, () -> true);

        assertThatNoException()
                .isThrownBy(() -> line.move(value));
    }
}