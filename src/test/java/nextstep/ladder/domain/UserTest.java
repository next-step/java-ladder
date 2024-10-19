package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    @Test
    @DisplayName("성공 - User 객체가 정상 생성 된다.")
    void initUserTest() {
        User user = new User("홍길동");
        assertThat(user).isNotNull();
        assertThat(user.getName()).isEqualTo("홍길동");
    }

    @Test
    @DisplayName("실패 - 사람의 이름이 5자를 초과할 경우 예외가 발생한다.")
    void validUserNameLengthTest() {
        assertThatThrownBy(() -> new User("홍홍길동길동"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최대 5자까지 부여할 수 있습니다.");
    }
}
