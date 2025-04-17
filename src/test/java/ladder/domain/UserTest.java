package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    @DisplayName("이름이 5자보다 길면 예외가 발생한다.")
    @Test
    public void testNameLength() {
        String name = "abcdef";
        try {
            new User(name);
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("이름은 5자 이하여야 합니다.");
        }
    }

    @DisplayName("이름을 가져온다.")
    @Test
    public void testGetName() {
        String name = "abcde";
        User user = new User(name);
        assert user.getName().equals(name);
    }
}
