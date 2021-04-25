package step4.laddergame.domain.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

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
        assertThat(player.checkName(new Name(pName))).isTrue();
    }

    @Test
    void 플레이어의이름을_추가한다() {
        Set<Name> names = new HashSet<>();
        player.addName(names);

        assertThat(names).contains(name);
    }

    @Test
    void 플레이어프린트() {
        System.out.println(player);
    }
}
