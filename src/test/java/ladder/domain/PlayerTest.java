package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    private Player player;
    private Name name;
    private String pName = "이름";

    @BeforeEach
    void setUp() {
        name = new Name(pName);
        player = new Player(name);
    }

    @Test
    void 플레이어를생성() {
        assertThat(player).isEqualTo(new Player(name));
    }

}
