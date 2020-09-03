package com.hskim.ladder.model;

import com.google.common.collect.ImmutableMap;
import com.hskim.ladder.ui.LadderResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private LadderResultView ladderResultView = new LadderResultView();

    @DisplayName("라인 출력 테스트")
    @RepeatedTest(10)
    void printLine() {
        // given
        Line line = new Line(new LadderLineIterator(9), new RandomRowIndexMaker());

        // when
        ladderResultView.printLine(line.getLadderPoints());
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
        System.out.println();
        ladderResultView.printLine(line.getLadderPoints());
    }

    @DisplayName("한 라인의 출발점과 도착점을 구하는 로직 테스트")
    @ParameterizedTest
    @MethodSource("provideLineAndResult")
    void getStartEndPointMap(Line line, Map<Integer, Integer> expected) {
        // when
        Map<Integer, Integer> result = line.getRouteInfo().getRouteMap();

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLineAndResult() {
        return Stream.of(
                // 0     1     2      3     4
                // |-----|     |------|     |
                Arguments.of(new Line(new LadderLineIterator(5), (bound) -> Arrays.asList(1, 3)),
                        ImmutableMap.of(0, 1, 1, 0, 2, 3, 3, 2, 4, 4)),
                // 0     1     2      3     4
                // |     |-----|     |------|
                Arguments.of(new Line(new LadderLineIterator(5), (bound) -> Arrays.asList(2, 4)),
                        ImmutableMap.of(0, 0, 1, 2, 2, 1, 3, 4, 4, 3))
        );
    }

}
