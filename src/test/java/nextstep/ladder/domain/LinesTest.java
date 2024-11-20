package nextstep.ladder.domain;

import nextstep.ladder.strategy.LineStrategy;
import nextstep.ladder.strategy.TrueLineStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @Test
    void 세명의참가자만큼_네줄로_사다리_생성() {
        LineStrategy lineStrategy = new TrueLineStrategy();
        Lines lines = new Lines();
        lines.generateLine(3, 4, lineStrategy);

        assertThat(lines.size()).isEqualTo(4);
        for (int i = 0; i < lines.size(); i++) {
            assertThatLineSize(lines, i);
            assertThatLinePatternIsCorrect(lines, i);
        }
    }

    private static void assertThatLinePatternIsCorrect(Lines lines, int linesIdx) {
        for (int j = 0; j < lines.getLineSize(linesIdx); j++) {
            assertThat(lines.getPoint(linesIdx, j)).isEqualTo(j % 2 == 0);
        }
    }

    private static void assertThatLineSize(Lines lines, int linesIdx) {
        assertThat(lines.getLineSize(linesIdx)).isEqualTo(2);
    }
}
