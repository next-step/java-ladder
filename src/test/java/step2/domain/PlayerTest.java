package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.IllegalPlayerName;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {

    @DisplayName("글자수 5자 초과시 익셉션 테스트")
    @Test
    void playerTest() {
        assertThrows(IllegalPlayerName.class, () -> new Player("kingTiger", 0));
    }

}
