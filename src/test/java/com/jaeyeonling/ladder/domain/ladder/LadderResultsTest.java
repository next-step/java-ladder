package com.jaeyeonling.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultsTest {
    @DisplayName("결과들 생성에 성공한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "꽝,5000,꽝,5000",
            "꽝"
    })
    void should_return_ladderResults_when_create_by_comma_separateValue(final String rawResults) {
        // when
        final LadderResults ladderResults = LadderResults.ofSeparator(rawResults);
        final int expectLength = rawResults.split(LadderResults.SEPARATOR).length;

        // then
        assertThat(ladderResults.size()).isEqualTo(expectLength);
    }

    @DisplayName("인덱스로 결과를 가져온다.")
    @Test
    void should_return_ladderResult_when_findByIndex() {
        // given
        final String rawResults = "a,b,c,d,e";
        final LadderResults ladderResults = LadderResults.ofSeparator(rawResults);

        // when
        final String[] expectLadderResults = rawResults.split(LadderResults.SEPARATOR);

        // then
        for (int i = 0; i < expectLadderResults.length; i++) {
            assertThat(ladderResults.findByIndex(i)).isEqualTo(expectLadderResults[i]);
        }
    }

}
