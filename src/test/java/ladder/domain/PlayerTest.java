package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @DisplayName("Player 객체 생성 시 이름 5글자 초과 시 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobbii", "bbororo", "tester", "jaewon"})
    public void 이름_5글자_초과_에러발생(String name) {
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Player 결과 테스트")
    @Test
    public void 결과_테스트() {
        List<Player> players = Arrays.asList(
                new Player("pobi"),
                new Player("honux"),
                new Player("crong"),
                new Player("jk")
        );

        List<String> results = Arrays.asList("꽝", "3000", "꽝", "5000");

        Ladder ladder = new Ladder(List.of(
                new Line(List.of(true, false, true)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, false)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, true))));

        assertThat(results.get(players.get(0).getPlayerPoint(0, ladder))).isEqualTo("꽝");
        assertThat(results.get(players.get(1).getPlayerPoint(1, ladder))).isEqualTo("3000");
        assertThat(results.get(players.get(2).getPlayerPoint(2, ladder))).isEqualTo("꽝");
        assertThat(results.get(players.get(3).getPlayerPoint(3, ladder))).isEqualTo("5000");
    }
}
