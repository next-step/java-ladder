package ladder.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerNameTest {
    public static final PlayerName JUN = new PlayerName("jun");
    public static final PlayerName POBI = new PlayerName("pobi");
    public static final PlayerName HONUX = new PlayerName("honux");
    public static final PlayerName JK = new PlayerName("jk");
    
    @Test
    @DisplayName("플레이어 이름 생성")
    void create() {
        assertThat(JUN).isNotNull();
    }
}