package ladder.ladder.domain;

import ladder.common.TestFeature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineGeneratorTest {

    @DisplayName("높이를 입력해서 첫번째 사다리 라인을 생성할 수 있다.")
    @Test
    public void generateFirstLadderLine() {
        LadderLine firstLadderLine = LadderLineGenerator.generateFirstLine(3);

        assertThat(firstLadderLine.getLines()).hasSize(3);
    }

    @DisplayName("사다리 의 중간 라인은 이전 라인을 바탕으로 생성한다. " +
            "같은 높이의 이전 라인의 연결여부가 참이면 현재 생성하는 라인은 거짓만 허용된다.")
    @Test
    public void lastLineGeneratedTest() {
        LadderLine prevLadderLine = LadderLine.of(Arrays.asList(Line.of(0, true), Line.of(1, true),
                Line.of(2, true)));

        LadderLine currentLadderLine = LadderLineGenerator.generateInnerLine(prevLadderLine, 3);

        List<Line> expected = TestFeature.generateLines(false, false, false);

        assertThat(currentLadderLine.getLines()).isEqualTo(expected);
    }

}
