package com.hskim.ladder.model;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        Lines lines = Lines.of(5, 6, (bound) -> Arrays.asList(1, 3, 5));

        // when & then
        assertThat(lines).isEqualTo(Lines.of(5, 6, (bound) -> Arrays.asList(1, 3, 5)));
    }

    @DisplayName("여러 라인의 출발점과 도착점을 구하는 로직 테스트")
    @Test
    void getStartEndPointMap() {
        // given
        Lines lines = makeLines();
        Map<Integer, Integer> expected = ImmutableMap.of(
                0, 4,
                1, 1,
                2, 3,
                3, 0,
                4, 2);

        // when
        Map<Integer, Integer> result = lines.getStartEndPointMap();

        // then
        assertThat(result).isEqualTo(expected);
    }

    private Lines makeLines() {
        // 0     1     2      3     4
        // |-----|     |------|     |
        // |     |-----|      |-----|
        // |     |     |------|     |
        // |-----|     |      |     |
        // |     |     |      |-----|
        // 0     1     2      3     4
        // result : 0 -> 4, 1 -> 1, 2 -> 3, 3 -> 0, 4 -> 2

        List<Line> lines = new LinkedList<>();
        lines.add(new Line(new LadderLineIterator(5), (bound) -> Arrays.asList(1, 3)));
        lines.add(new Line(new LadderLineIterator(5), (bound) -> Arrays.asList(2, 4)));
        lines.add(new Line(new LadderLineIterator(5), (bound) -> Collections.singletonList(3)));
        lines.add(new Line(new LadderLineIterator(5), (bound) -> Collections.singletonList(1)));
        lines.add(new Line(new LadderLineIterator(5), (bound) -> Collections.singletonList(4)));

        return new Lines((lines));
    }
}
