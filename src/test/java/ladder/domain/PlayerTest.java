package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    public static final Position POSITION = new Position(0);

    @DisplayName("null 으로 생성 시 에러")
    @Test
    void createWithNull() {
        assertThrows(IllegalArgumentException.class, () -> new Player(null, POSITION));
    }

    @DisplayName("공백으로 생성 시 에러")
    @Test
    void createWithBlank() {
        assertThrows(IllegalArgumentException.class, () -> new Player("", POSITION));
    }

    @DisplayName("5글자 이상으로 생성 시 에러")
    @Test
    void createWithLong() {
        assertThrows(IllegalArgumentException.class, () -> new Player("123456", POSITION));
    }

    @DisplayName("결과 생성")
    @Test
    void createResult() {
        Player player = new Player("pobi", POSITION);
        List<String> results = List.of("a");
        Player actual = player.checkResult(results);

        Player expected = new Player("pobi", POSITION, "a");
        assertEquals(expected, actual);
    }
}