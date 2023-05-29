package ladder;

import ladder.dto.Line;
import ladder.dto.Player;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerTest {

    @Test
    void 새로운_플레이어이름_생성() {
        Player player = new Player("test",0);
        assertThat(player.getName()).isEqualTo("test");
    }

    @Test
    void 플레이어이름_체크사항() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Player("",0);
                });

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Player(null,0);
                });

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Player("일이삼사오육",0);
                });
    }

    @Test
    void 위치() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Player("test",-1);
                });
    }

    @Test
    void moveLocationInLine() {
        Player player1 = new Player("플레이어1", 0);
        Player player2 = new Player("플레이어2", 1);
        Player player3 = new Player("플레이어3", 2);
        Player player4 = new Player("플레이어4", 3);
        Line line = new Line(List.of(true, false, true));

        player1.moveLocationInLine(line);
        player2.moveLocationInLine(line);
        player3.moveLocationInLine(line);
        player4.moveLocationInLine(line);

        assertThat(player1.getLocation()).isEqualTo(1);
        assertThat(player2.getLocation()).isEqualTo(0);
        assertThat(player3.getLocation()).isEqualTo(3);
        assertThat(player4.getLocation()).isEqualTo(2);
    }
}
