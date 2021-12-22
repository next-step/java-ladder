package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderStringTest {

    @DisplayName("LadderString은 1~5자로 생성. 동등성을 가짐")
    @Test
    void create() {
        String ladderString = "5000";
        assertThat(new LadderStringValue(ladderString)).isEqualTo(new LadderStringValue(ladderString));
    }

    @DisplayName("LadderString은 1~5자 이외에는 예외발생")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "sixsix"})
    void valid(String ladderString) {
        assertThatThrownBy(() -> new LadderStringValue(ladderString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값은 1~5자입니다.");
    }

}