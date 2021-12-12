package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderStringTest {

    @DisplayName("LadderString 생성")
    @Test
    void create() {
        String ladderString = "5000";

        Assertions.assertThat(new LadderString(ladderString)).isEqualTo(new LadderString(ladderString));
    }

    @DisplayName("결과는 1~5자")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "sixsix"})
    void valid(String ladderString) {
        assertThatThrownBy(() -> new LadderString(ladderString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값은 1~5자입니다.");
    }

}