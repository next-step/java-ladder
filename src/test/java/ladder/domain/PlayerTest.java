package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @DisplayName("null 으로 생성 시 에러")
    @Test
    void createWithNull() {
        assertThrows(IllegalArgumentException.class, () -> new Player(null));
    }

    @DisplayName("공백으로 생성 시 에러")
    @Test
    void createWithBlank() {
        assertThrows(IllegalArgumentException.class, () -> new Player(""));
    }

    @DisplayName("5글자 이상으로 생성 시 에러")
    @Test
    void createWithLong() {
        assertThrows(IllegalArgumentException.class, () -> new Player("123456"));
    }
}