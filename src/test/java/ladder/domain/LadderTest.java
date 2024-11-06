package ladder.domain;

import ladder.domain.util.LineGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {


    private Players players;
    private LineGenerator horizontalGenerator;
    private int verticalLadderSize;
    private Lines lines;

    @BeforeEach
    void setUp() {
        players = new Players("pobi,crong,honux,jk");
        horizontalGenerator = () -> true;
        verticalLadderSize = 5;
        lines = new Lines(List.of(
                new Line(4, horizontalGenerator),
                new Line(4, horizontalGenerator),
                new Line(4, horizontalGenerator),
                new Line(4, horizontalGenerator),
                new Line(4, horizontalGenerator)
        ));
    }

    @Test
    void create() {
        Ladder actual = new Ladder(players, verticalLadderSize, horizontalGenerator);
        Ladder expected = new Ladder(players, new Lines(List.of(
                new Line(4, horizontalGenerator),
                new Line(4, horizontalGenerator),
                new Line(4, horizontalGenerator),
                new Line(4, horizontalGenerator),
                new Line(4, horizontalGenerator)
                )));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getLines() {
        Ladder ladder = new Ladder(players, lines);
        Lines actual = ladder.getLines();

        assertThat(actual).isEqualTo(lines);
    }

    @Test
    void getPlayers() {
        Ladder ladder = new Ladder(players, lines);
        Players actual = ladder.getPlayers();

        assertThat(actual).isEqualTo(players);
    }
}
