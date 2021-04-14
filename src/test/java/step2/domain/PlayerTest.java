package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.IllegalPlayerName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {

    @DisplayName("글자수 5자 초과시 익셉션 테스트")
    @Test
    void playerTest() {
        assertThrows(IllegalPlayerName.class, () -> new Player("kingTiger"));
    }

    @DisplayName("getName호출시 공백포함 6글자가 반환되는지 테스트")
    @Test
    void getNameTest() {
        Player tiger = new Player("Tiger");
        String name = tiger.getName();

        assertEquals(name, " Tiger");
    }
}
