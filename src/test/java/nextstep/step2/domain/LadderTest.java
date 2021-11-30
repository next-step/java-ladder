package nextstep.step2.domain;

import nextstep.step2.dto.LadderInformation;
import nextstep.step2.vo.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderTest {

    @DisplayName("정상 생성 테스트")
    @Test
    void createTest() {
        Width width = Width.of(2);
        Height height = Height.of(2);
        LadderInformation ladderInformation = LadderInformation.of(width, height);
        BooleanGenerateStrategy booleanGenerateStrategy = () -> true;

        Ladder ladder = Ladder.of(ladderInformation, booleanGenerateStrategy);

        assertThat(ladder)
                .isEqualTo(Ladder.of(
                        Lines.of(Arrays.asList(
                                Line.of(width, booleanGenerateStrategy),
                                Line.of(width, booleanGenerateStrategy)
                        ))
                ));
    }

    @DisplayName("생성 실패 테스트")
    @Test
    void createFailTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Width width = Width.of(1);
            Height height = Height.of(2);
            LadderInformation ladderInformation = LadderInformation.of(width, height);
            BooleanGenerateStrategy booleanGenerateStrategy = () -> true;
            Ladder.of(ladderInformation, booleanGenerateStrategy);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Width width = Width.of(2);
            Height height = Height.of(0);
            LadderInformation ladderInformation = LadderInformation.of(width, height);
            BooleanGenerateStrategy booleanGenerateStrategy = () -> true;
            Ladder.of(ladderInformation, booleanGenerateStrategy);
        });
    }

    /*
    |-| |
    | |-|
     */
    @DisplayName("위 모양의 사다리를 정상적으로 이동 한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:2", "1:0", "2:1"}, delimiter = ':')
    void playTest(int startPoint, int endPoint) {
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

        Ladder ladder = Ladder.of(lines);

        assertThat(ladder.play(Point.of(startPoint))).isEqualTo(Point.of(endPoint));
    }

}
