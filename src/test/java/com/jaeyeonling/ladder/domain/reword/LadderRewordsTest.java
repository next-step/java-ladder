package com.jaeyeonling.ladder.domain.reword;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderRewordsTest {
    @DisplayName("결과들 생성에 성공한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "꽝,5000,꽝,5000",
            "꽝"
    })
    void create(final String rawRewords) {
        // when
        final LadderRewords ladderRewords = LadderRewords.ofSeparator(rawRewords);
        final int expectLength = rawRewords.split(LadderRewords.SEPARATOR).length;

        // then
        assertThat(ladderRewords.size()).isEqualTo(expectLength);
    }

    @DisplayName("인덱스로 결과를 가져온다.")
    @Test
    void findLadderRewordBy() {
        // given
        final String rawRewords = "a,b,c,d,e";
        final LadderRewords ladderRewords = LadderRewords.ofSeparator(rawRewords);

        // when
        final String[] expectLadderRewords = rawRewords.split(LadderRewords.SEPARATOR);

        // then
        for (int i = 0; i < expectLadderRewords.length; i++) {
            final LadderReword ladderReword = ladderRewords.findLadderRewordBy(i);
            assertThat(ladderReword).isEqualTo(LadderReword.valueOf(expectLadderRewords[i]));
        }
    }
}
