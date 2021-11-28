package nextstep.step2.domain;

import nextstep.step2.dto.LadderInformation;
import nextstep.step2.vo.BooleanGenerateStrategy;
import nextstep.step2.vo.Height;
import nextstep.step2.vo.Lines;
import nextstep.step2.vo.Width;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("정상 생성 테스트")
    @Test
    void createTest() {
        Width width = Width.create(2);
        Height height = Height.create(2);
        LadderInformation ladderInformation = LadderInformation.create(width, height);
        BooleanGenerateStrategy booleanGenerateStrategy = () -> true;

        Ladder ladder = Ladder.createWithLadderInformation(ladderInformation, booleanGenerateStrategy);

        assertThat(ladder)
                .isEqualTo(Ladder.create(
                        Lines.create(Arrays.asList(
                                Line.createWithWidth(width, booleanGenerateStrategy),
                                Line.createWithWidth(width, booleanGenerateStrategy)
                        ))
                ));
    }

}
