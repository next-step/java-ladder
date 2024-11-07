package ladder.domain;

import ladder.domain.util.CrossGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
