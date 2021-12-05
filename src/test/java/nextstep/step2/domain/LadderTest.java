package nextstep.step2.domain;

import nextstep.step2.dto.LadderInfoDto;
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
        Width width = Width.from(2);
        Height height = Height.from(2);
        LadderInfoDto ladderInfoDto = LadderInfoDto.of(width, height);
        BooleanGenerateStrategy booleanGenerateStrategy = () -> true;

        Ladder ladder = Ladder.ofWithLadderInfoAndStrategy(ladderInfoDto, booleanGenerateStrategy);

        assertThat(ladder)
                .isEqualTo(Ladder.from(
                        Lines.from(Arrays.asList(
                                Line.ofWithWidthAndStrategy(width, booleanGenerateStrategy),
                                Line.ofWithWidthAndStrategy(width, booleanGenerateStrategy)
                        ))
                ));
    }

    @DisplayName("생성 실패 테스트")
    @Test
    void createFailTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Width width = Width.from(1);
            Height height = Height.from(2);
            LadderInfoDto ladderInfoDto = LadderInfoDto.of(width, height);
            BooleanGenerateStrategy booleanGenerateStrategy = () -> true;
            Ladder.ofWithLadderInfoAndStrategy(ladderInfoDto, booleanGenerateStrategy);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Width width = Width.from(2);
            Height height = Height.from(0);
            LadderInfoDto ladderInfoDto = LadderInfoDto.of(width, height);
            BooleanGenerateStrategy booleanGenerateStrategy = () -> true;
            Ladder.ofWithLadderInfoAndStrategy(ladderInfoDto, booleanGenerateStrategy);
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
        Lines lines = Lines.from(
                Arrays.asList(
                        Line.from(Arrays.asList(
                                Bridge.RIGHT, Bridge.LEFT, Bridge.DOWN
                        )),
                        Line.from(Arrays.asList(
                                Bridge.DOWN, Bridge.RIGHT, Bridge.LEFT
                        ))
                )
        );

        Ladder ladder = Ladder.from(lines);

        assertThat(ladder.play(Point.from(startPoint))).isEqualTo(Point.from(endPoint));
    }

}
