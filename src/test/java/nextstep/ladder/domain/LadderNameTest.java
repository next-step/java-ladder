package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nextstep.ladder.exception.LetterLimitException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderNameTest {
    @Test
    @DisplayName("LadderName 생성 테스트")
    void create() {
        LadderName ladderName = LadderName.of("aaaaa");
        assertThat(ladderName).isEqualTo(LadderName.of("aaaaa"));
    }

    @Test
    @DisplayName("5글자 이상 예외")
    void letterLimitException() {
        assertThatThrownBy(() -> LadderName.of("asdasd"))
            .hasMessageContaining("5글자")
            .isInstanceOf(LetterLimitException.class);
    }

    @Test
    void findByName() {
        LadderName ladderName = LadderName.of("a");
        assertThat(ladderName.findName("a")).isTrue();
    }

    @Test
    void findByNameFalse() {
        LadderName ladderName = LadderName.of("a");
        assertThat(ladderName.findName("b")).isFalse();
    }


}