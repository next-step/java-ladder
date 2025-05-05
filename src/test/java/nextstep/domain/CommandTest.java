package nextstep.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CommandTest {
    @Test
    @DisplayName("사다리게임 커맨드 테스트")
    void equalsTest() {
        assertTrue(CommandEnum.ALL.equals("all"));
    }
}
