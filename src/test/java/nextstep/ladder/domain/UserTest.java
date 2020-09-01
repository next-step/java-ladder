package nextstep.ladder.domain;

import nextstep.ladder.utils.LadderValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class UserTest {

    @ParameterizedTest
    @DisplayName("유저의 이름이 공백 또는 null인지 확인")
    @NullAndEmptySource
    void validateLadderNameIsBlank(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->{
                    LadderValidation.validateUserNameIsBlank(name);
                });
    }

    @Test
    @DisplayName("유저의 이름이 6자 이상이면 Exception 발생")
    void validateLadderNameLength() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    LadderValidation.validateUserNameLength("hangyeol");
                });
    }

}
