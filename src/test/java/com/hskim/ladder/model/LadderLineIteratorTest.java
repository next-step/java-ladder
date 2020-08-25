package com.hskim.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineIteratorTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        LadderLineIterator ladderLineIterator = new LadderLineIterator(6);

        // when & then
        assertThat(ladderLineIterator).isEqualTo(new LadderLineIterator(6));
    }

    @DisplayName("인자로 받은 targets에 counter가 속해있는지 테스트")
    @ParameterizedTest
    @MethodSource("provideTargetsAndResult")
    void isTargetCounter(List<Integer> targets, boolean expected) {
        // given
        LadderLineIterator ladderLineIterator = new LadderLineIterator(6, 2);

        // when
        boolean result = ladderLineIterator.isTargetCounter(targets);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideTargetsAndResult() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), true),
                Arguments.of(Arrays.asList(4, 5, 6), false),
                Arguments.of(Arrays.asList(1, 3, 5, 7, 9), false),
                Arguments.of(Arrays.asList(2, 4, 6, 8, 10), true)
        );
    }

    @DisplayName("현재 카운터가 시작지점에 있는지 여부 테스트")
    @ParameterizedTest
    @MethodSource("provideIteratorAndResult")
    void isOnStartIndex(LadderLineIterator ladderLineIterator, boolean expected) {
        // given
        LadderLineIterator given = ladderLineIterator;

        // when
        boolean result = given.isOnStartIndex();

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideIteratorAndResult() {
        return Stream.of(
                Arguments.of(new LadderLineIterator(6, 0), true),
                Arguments.of(new LadderLineIterator(6, 1), false),
                Arguments.of(new LadderLineIterator(6, 5), false),
                Arguments.of(new LadderLineIterator(6, 7), false)
        );
    }

    @DisplayName("현재 카운터가 종료지점에 있는지 여부 테스트")
    @ParameterizedTest
    @MethodSource("provideIteratorAndResult2")
    void isOnLastIndex(LadderLineIterator ladderLineIterator, boolean expected) {
        // given
        LadderLineIterator given = ladderLineIterator;

        // when
        boolean result = given.isOnLastIndex();

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideIteratorAndResult2() {
        return Stream.of(
                Arguments.of(new LadderLineIterator(6, 0), false),
                Arguments.of(new LadderLineIterator(6, 1), false),
                Arguments.of(new LadderLineIterator(6, 5), false),
                Arguments.of(new LadderLineIterator(6, 6), true)
        );
    }

    @DisplayName("카운터 증가 테스트")
    @Test
    void next() {
        // given
        LadderLineIterator ladderLineIterator = new LadderLineIterator(5, 0);

        // when
        ladderLineIterator.next();
        ladderLineIterator.next();

        // then
        assertThat(ladderLineIterator).isEqualTo(new LadderLineIterator(5, 2));
    }

    @DisplayName("반복가능 상태 테스트")
    @ParameterizedTest
    @MethodSource("provideIteratorAndResult3")
    void hasNext(LadderLineIterator ladderLineIterator, boolean expected) {
        // given
        LadderLineIterator given = ladderLineIterator;

        // when
        boolean result = ladderLineIterator.hasNext();

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideIteratorAndResult3() {
        return Stream.of(
                Arguments.of(new LadderLineIterator(6, 0), true),
                Arguments.of(new LadderLineIterator(6, 3), true),
                Arguments.of(new LadderLineIterator(6, 6), true),
                Arguments.of(new LadderLineIterator(6, 7), false)
        );
    }

}
