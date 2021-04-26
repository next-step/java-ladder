package step4.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.exception.IllegalPlayerName;

public class PlayerTest {

    @DisplayName("플레이어 이름이 5글자 넘을경우 exception 테스트")
    @Test
    void playerNameTest() {
        Assertions.assertThrows(IllegalPlayerName.class, () -> new Player("tiger00", new Position(1)));
    }
}
