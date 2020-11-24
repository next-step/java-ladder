package nextstep.ladder.entity;

import nextstep.ladder.entity.exception.IllegalUserNameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi", "honux", "crong", "jk"})
    void test_create_user_success(String username) {
        // When
        User user = new User(username);

        // Then
        assertThat(user.getName()).isEqualTo(username);
    }

    @ParameterizedTest
    @NullSource
    void test_create_user_fail_null(String username) {
        IllegalUserNameException illegalUserNameException
                = assertThrows(IllegalUserNameException.class, () -> new User(username));
        assertThat(illegalUserNameException).hasMessageStartingWith("사용자 이름은 빈 공백이거나 5자를 초과하여 입력할 수 없습니다.");
    }

    @ParameterizedTest
    @EmptySource
    void test_create_user_fail_blank(String username) {
        IllegalUserNameException illegalUserNameException
                = assertThrows(IllegalUserNameException.class, () -> new User(username));
        assertThat(illegalUserNameException).hasMessageStartingWith("사용자 이름은 빈 공백이거나 5자를 초과하여 입력할 수 없습니다.");
    }


}