package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.exception.UserNameInvalidException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {
    @Test
    @DisplayName("User 가 정상적으로 생성되는지 확인")
    void testConstructorValid() {
        User user = new User("John");

        assertThat(user).isEqualTo(new User("John"));
    }

    @Test
    @DisplayName("User 가 null 이면 예외가 발생하는지 확인")
    void testConstructorInvalidNullName() {
        assertThrows(UserNameInvalidException.class, () -> new User(null));
    }

    @Test
    @DisplayName("User 가 빈 문자열이면 예외가 발생하는지 확인")
    void testConstructorInvalidEmptyName() {
        assertThrows(UserNameInvalidException.class, () -> new User(""));
    }

    @Test
    @DisplayName("User 가 5자 초과이면 예외가 발생하는지 확인")
    void testConstructorInvalidLongName() {
        assertThrows(UserNameInvalidException.class, () -> new User("abcdef"));
    }

    @Test
    @DisplayName("User equals 메서드가 정상적으로 동작하는지 확인")
    void testEquals() {
        User user1 = new User("Alice");
        User user2 = new User("Alice");
        User user3 = new User("Bob");

        assertThat(user1.equals(user2)).isTrue();
        assertThat(user1.equals(user3)).isFalse();
    }
}
