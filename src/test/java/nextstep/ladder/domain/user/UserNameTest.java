package nextstep.ladder.domain.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 사람 이름은 최대 5글자까지 부여할 수 있다.
 */
class UserNameTest {

    @Test
    void 이름_5글자_초과시_에러발생() {
        assertThatThrownBy(() -> new User("pobipo", 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 이름은 최대 5글자까지 입력 가능합니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 이름_공백_또는_null일경우_에러발생(String value) {
        assertThatThrownBy(() -> new User(value, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 이름은 공백일 수 없습니다.");
    }

}