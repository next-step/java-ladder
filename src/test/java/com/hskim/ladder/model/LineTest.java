package com.hskim.ladder.model;

import com.hskim.ladder.ui.LadderResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("라인 출력 테스트")
    @RepeatedTest(10)
    void printLine() {
        // given
        Line line = new Line(new LadderLineIterator(9), new RandomRowIndexMaker());
        LadderResultView ladderResultView = new LadderResultView();

        // when
        ladderResultView.printLine(line.getLadderPoints());
        System.out.println();
    }

    @DisplayName("라인 생성 테스트")
    @Test
    void create() {
        // given
        Line line = new Line(new LadderLineIterator(9), (bound) -> Arrays.asList(1, 3, 5, 7));

        // when & then
        assertThat(line).isEqualTo(new Line(new LadderLineIterator(9), (bound) -> Arrays.asList(1, 3, 5, 7)));
    }

    @DisplayName("인원수 6, 사다리가 3개 있는 라인 출력 테스트 (     |-----|     |-----|     |-----|)")
    @Test
    void print() {
        // given
        Line line = new Line(new LadderLineIterator(6), (bound) -> Arrays.asList(1, 3, 5));
        LadderResultView ladderResultView = new LadderResultView();

        // when
        ladderResultView.printLine(line.getLadderPoints());
    }
}
