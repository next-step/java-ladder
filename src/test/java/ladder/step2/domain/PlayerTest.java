package ladder.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    public static final Player JUN = new Player(PlayerNameTest.JUN);
    public static final Player POBI = new Player(PlayerNameTest.POBI);
    public static final Player HONUX = new Player(PlayerNameTest.HONUX);
    public static final Player JK = new Player(PlayerNameTest.JK);
    
    @Test
    @DisplayName("플레이어 생성")
    void create() {
        assertThat(JUN).isNotNull();
    }
}