package nextstep.ladder.domain;

import nextstep.ladder.strategy.LineStrategy;
import nextstep.ladder.strategy.TrueLineStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NextStepLinesTest {

    public static NextStepLines lines() {
        LineStrategy lineStrategy = new TrueLineStrategy();
        NextStepLines nextStepLines = new NextStepLines();
        nextStepLines.generateLine(4, 3, lineStrategy);
        return nextStepLines;
    }

    @Test
    void 세명의참가자만큼_네줄로_사다리_생성() {
        LineStrategy lineStrategy = new TrueLineStrategy();
        NextStepLines nextStepLines = new NextStepLines();
        nextStepLines.generateLine(3, 4, lineStrategy);

        assertThat(nextStepLines.size()).isEqualTo(4);
        for (int i = 0; i < nextStepLines.size(); i++) {
            assertThatLineSize(nextStepLines, i);
            assertThatLinePatternIsCorrect(nextStepLines, i);
        }
    }

    private static void assertThatLinePatternIsCorrect(NextStepLines nextStepLines, int linesIdx) {
        for (int j = 0; j < nextStepLines.getLineSize(linesIdx); j++) {
            assertThat(nextStepLines.getPoint(linesIdx, j)).isEqualTo(j % 2 == 0);
        }
    }

    private static void assertThatLineSize(NextStepLines nextStepLines, int linesIdx) {
        assertThat(nextStepLines.getLineSize(linesIdx)).isEqualTo(2);
    }
}
