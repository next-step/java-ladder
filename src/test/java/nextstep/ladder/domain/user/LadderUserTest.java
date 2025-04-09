package nextstep.ladder.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderUserTest {

    @DisplayName("User 인스턴스 만들기")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new LadderUser("jk"));
    }

    @DisplayName("유저 이름이 5자가 넘어가면 User 생성자 호출시 예외를 반환")
    @Test
    public void testConstructor_throwException() {
        assertThatThrownBy(() -> new LadderUser("testUser1"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름은 최대 5자를 넘을 수 없습니다.");
    }
}
