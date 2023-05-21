package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerTest {

    @Test
    void create() {
        Player player1 = new Player("HI");
        assertThat(player1.getName()).isEqualTo("HI");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Player player2 = new Player("HEELLO");
        }).withMessageMatching("사람에 이름을 최대5글자까지 가능합니다.");
    }

    @DisplayName("결과 테스트")
    @Test
    void getResult() {
        Ladder ladder = new Ladder(5);
        ladder.addLine(new Line(() -> Arrays.asList(true, false, true)));
        ladder.addLine(new Line(() -> Arrays.asList(false, true, false)));
        ladder.addLine(new Line(() -> Arrays.asList(true, false, false)));
        ladder.addLine(new Line(() -> Arrays.asList(false, true, false)));
        ladder.addLine(new Line(() -> Arrays.asList(true, false, true)));
        List<Player> players = Arrays.asList(
                new Player("pobi"),
                new Player("honux"),
                new Player("crong"),
                new Player("jk")
        );
        List<String> results = Arrays.asList("꽝", "5000", "꽝", "3000");
        assertThat(results.get(players.get(0).getPlayerResultIndex(0, ladder))).isEqualTo("꽝");
        assertThat(results.get(players.get(1).getPlayerResultIndex(1, ladder))).isEqualTo("3000");
        assertThat(results.get(players.get(2).getPlayerResultIndex(2, ladder))).isEqualTo("꽝");
        assertThat(results.get(players.get(3).getPlayerResultIndex(3, ladder))).isEqualTo("5000");
    }

}
