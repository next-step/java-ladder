package ladder.domain;

import ladder.domain.generator.CrossGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {


    private Players players;
    private CrossGenerator falseGenerator;
    private int verticalLadderSize;
    private Lines lines;

    @BeforeEach
    void setUp() {
        players = new Players("pobi,crong,honux,jk");
        falseGenerator = () -> false;
        verticalLadderSize = 5;
        lines = new Lines(List.of(
                new Line(4, falseGenerator),
                new Line(4, falseGenerator),
                new Line(4, falseGenerator),
                new Line(4, falseGenerator),
                new Line(4, falseGenerator)
        ));
    }

    @Test
    @DisplayName("생성자로 사다리를 생성한다")
    void create() {
        Ladder actual = new Ladder(players, verticalLadderSize, falseGenerator);
        Ladder expected = new Ladder(players, new Lines(List.of(
                new Line(4, falseGenerator),
                new Line(4, falseGenerator),
                new Line(4, falseGenerator),
                new Line(4, falseGenerator),
                new Line(4, falseGenerator)
                )));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("라인목록을 조회한다")
    void getLines() {
        Ladder ladder = new Ladder(players, lines);
        Lines actual = ladder.getLines();

        assertThat(actual).isEqualTo(lines);
    }

    @Test
    @DisplayName("플레이어 목록을 조회한다")
    void getPlayers() {
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
