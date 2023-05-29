package ladder.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    Player player;
    List<Boolean> points;

    @BeforeEach
    void setPlayers() {
        player = new Player(new PlayerName("test"), 1);
        points = new ArrayList<>();
        points.add(true);
        points.add(true);
    }

    @Test
    void moveLeft() {
        player.moveLeft();
        assertThat(player.getPoint()).isEqualTo(0);
    }

    @Test
    void moveRight() {
        player.moveRight();
        assertThat(player.getPoint()).isEqualTo(2);
    }
}