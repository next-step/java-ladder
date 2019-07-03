package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.domain.ladder.LadderReword;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderRewordFormatterTest extends FormatterSupport {

    @DisplayName("사다리 결과 포매터 생성에 성공한다.")
    @Test
    void should_create() {
        // then
        assertThat(ladderRewordFormatter).isNotNull();
    }

    @DisplayName("포맷팅 후 입력과 같은 값이어야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연",
            "matt",
            "kjy",
            "ggg",
            "다섯글자다"
    })
    void should_equals_formattedLadderReword_and_ladderReword(final String rawLadderReword) {
        // given
        final LadderReword ladderReword = LadderReword.valueOf(rawLadderReword);

        // when
        final String formattedLadderReword = ladderRewordFormatter.format(ladderReword);

        // then
        assertThat(formattedLadderReword).isEqualTo(rawLadderReword);
    }
}
