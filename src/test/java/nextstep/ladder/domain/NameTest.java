package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {
    @Test
    @DisplayName("참가자 이름이 공백이거나 null이면 예외가 발생한다")
    void name_null_or_blank_exception() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            new Name("");
            new Name(null);
        });
    }

    @Test
    @DisplayName("참가자 이름은 5자가 넘어가면 예외가 발생한다")
    void name_length_exception() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            new Name("kimbro");
        });
    }
}