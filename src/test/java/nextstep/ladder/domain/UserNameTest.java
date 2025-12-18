package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 사람 이름은 최대 5글자까지 부여할 수 있다.
 */
class UserNameTest {

    @Test
    void 이름_5글자_초과시_에러발생() {
        assertThatThrownBy(() -> new User("pobipo"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 이름은 최대 5글자까지 입력 가능합니다.");
    }

}