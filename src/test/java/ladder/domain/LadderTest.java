package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static ladder.domain.PlayersTest.POBI_HONUX_CRONG_JK;
import static ladder.domain.PlayersTest.PLAYERS1;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    public static final int VERTICAL_LADDER_SIZE = 5;
    public static final int PLAYERS_COUNT = 4;


    @Test
    @DisplayName("생성자로 사다리를 생성한다")
    void create() {
        Players players = new Players(POBI_HONUX_CRONG_JK);
        Lines lines = new Lines(List.of(
                new Line(players.size(), () -> false),
                new Line(players.size(), () -> false),
                new Line(players.size(), () -> false),
                new Line(players.size(), () -> false),
                new Line(players.size(), () -> false)
        ));

        Ladder actual = new Ladder(players, VERTICAL_LADDER_SIZE, () -> false);
        Ladder expected = new Ladder(players, lines);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("라인목록을 조회한다")
    void getLines() {
        Players players = new Players(POBI_HONUX_CRONG_JK);
        Lines lines = new Lines(List.of(
                new Line(players.size(), () -> false),
                new Line(players.size(), () -> false),
                new Line(players.size(), () -> false),
                new Line(players.size(), () -> false),
                new Line(players.size(), () -> false)
        ));

        Ladder ladder = new Ladder(players, lines);
        Lines actual = ladder.getLines();

        assertThat(actual).isEqualTo(lines);
    }

    @Test
    @DisplayName("플레이어 목록을 조회한다")
    void getPlayers() {
        Players players = new Players(POBI_HONUX_CRONG_JK);
        Lines lines = new Lines(List.of(
                new Line(players.size(), () -> false),
                new Line(players.size(), () -> false),
                new Line(players.size(), () -> false),
                new Line(players.size(), () -> false),
                new Line(players.size(), () -> false)
        ));

        Ladder ladder = new Ladder(players, lines);
        Players actual = ladder.getPlayers();

        assertThat(actual).isEqualTo(players);
    }

    @Test
    @DisplayName("결과를 생성한다")
    void results() {
        Players arrivalPlayers = new Players(List.of(
                new PlayerName("pobi"),
                new PlayerName("honux"),
                new PlayerName("crong"),
                new PlayerName("jk")
        ), new Vertical());
        Lines lines = new Lines(List.of(
                new Line(PLAYERS1.size(), () -> false),
                new Line(PLAYERS1.size(), () -> false),
                new Line(PLAYERS1.size(), () -> false),
                new Line(PLAYERS1.size(), () -> false),
                new Line(PLAYERS1.size(), () -> false)
        ));
        Ladder ladder = new Ladder(arrivalPlayers, lines);
        Rewards rewards = new Rewards("꽝,3000,꽝,5000", 4);

        Results actual = ladder.results(rewards);
        Results expected = new Results(Map.of(
                new PlayerName("pobi"), new RewardName("꽝"),
                new PlayerName("honux"), new RewardName("3000"),
                new PlayerName("crong"), new RewardName("꽝"),
                new PlayerName("jk"), new RewardName("5000")
        ));

        assertThat(actual).isEqualTo(expected);
    }
}
