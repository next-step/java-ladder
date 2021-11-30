package nextstep.step2.vo;

import nextstep.step2.domain.Line;
import nextstep.step2.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LinesTest {

    @DisplayName("Null or Empty input illegal exception")
    @Test
    void nullOrEmptyTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> Lines.of(null));
        assertThatIllegalArgumentException().isThrownBy(() -> Lines.of(Collections.emptyList()));
    }

    @DisplayName("정상 생성 테스트")
    @Test
    void createTEst() {
        assertThat(Lines.of(Arrays.asList(Line.of(2, () -> true))))
                .isEqualTo(Lines.of(Arrays.asList(Line.of(2, () -> true))));
    }

    /*
    |-| |
    | |-|
     */
    @DisplayName("위 모양의 사다리를 정상적으로 이동 한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:2", "1:0", "2:1"}, delimiter = ':')
    void moveTest(int startPoint, int endPoint) {
        Lines lines = Lines.of(
                Arrays.asList(
                        Line.of(Arrays.asList(
                                Bridge.RIGHT, Bridge.LEFT, Bridge.DOWN
                        )),
                        Line.of(Arrays.asList(
                                Bridge.DOWN, Bridge.RIGHT, Bridge.LEFT
                        ))
                )
        );

        assertThat(lines.move(Point.of(startPoint))).isEqualTo(Point.of(endPoint));
    }

}
