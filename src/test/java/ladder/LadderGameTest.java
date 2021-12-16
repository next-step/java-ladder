package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class LadderGameTest {
    @BeforeEach
    void init() {
        String input = "pobi,honux,crong,jk 5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("사다리 게임을 실행한다. (매번 다른 사다리가 출력된다.)")
    @Test
    public void playLadder() {
        LadderGame.play();
    }
}
