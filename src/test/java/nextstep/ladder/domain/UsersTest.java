package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class UsersTest {

    @DisplayName("Users 인스턴스 만들기")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new Users("pobi,honux,crong,jk"));
    }

}
