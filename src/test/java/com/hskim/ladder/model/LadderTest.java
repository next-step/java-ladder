package com.hskim.ladder.model;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        Ladder ladder = new Ladder(new LadderHeight(5),
                getMockLines());

        // when
        Ladder expected = new Ladder(new LadderHeight(5),
                getMockLines());

        // then
        assertThat(ladder).isEqualTo(expected);
    }

    @DisplayName("생성 테스트 - 빌더이용")
    @Test
    void create_use_builder() {
        // given
        Ladder ladder = new Ladder.LadderBuilder(getMockLines())
                .setLadderHeight(new LadderHeight(5))
                .build();

        // when
        Ladder expected = new Ladder(new LadderHeight(5),
                        getMockLines());

        // then
        assertThat(ladder).isEqualTo(expected);
    }

    private Lines getMockLines() {
        return Lines.of(5, 5, (bound) -> Arrays.asList(1, 3));
    }

    @DisplayName("사다리의 출발점과 도착점을 구하는 로직 테스트")
    @Test
    void getNavigateResult() {
        // given
        Lines lines = makeLines();
        Ladder ladder = new Ladder(new LadderHeight(5), lines);
        Map<Integer, Integer> expected = ImmutableMap.of(
                0, 4,
                1, 1,
                2, 3,
                3, 0,
                4, 2);

        // when
        Map<Integer, Integer> result = ladder.getNavigateResult().getRouteMap();

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
