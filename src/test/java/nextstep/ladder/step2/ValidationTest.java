package nextstep.ladder.step2;

import nextstep.ladder.step2.domain.Validation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @Test
    @DisplayName("입력 값이 null 이거나 빈 문자열 일 때 예외 발생 ")
    void create() {
        assertAll(
                () -> assertThatThrownBy(() ->  Validation.isEmptyAndNull(null)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() ->  Validation.isEmptyAndNull("")).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() ->  Validation.isEmptyAndNull(" ")).isInstanceOf(IllegalArgumentException.class)
        );
    }

}