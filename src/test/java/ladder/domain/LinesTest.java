package ladder.domain;

import ladder.domain.util.LineGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.instrument.UnmodifiableClassException;
import java.util.ArrayList;
import java.util.List;

import static ladder.domain.PlayersTest.PLAYERS1;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    private int playersCount;
    private LineGenerator generator;
    private int verticalLadderSize;

    @BeforeEach
    void setUp() {
        playersCount = PLAYERS1.size();
        verticalLadderSize = 5;
        generator = () -> true;
    }

    @Test
    void create() {
        Lines actual = new Lines(PLAYERS1, verticalLadderSize, generator);
        Lines expected = new Lines(List.of(
                new Line(playersCount, generator),
                new Line(playersCount, generator),
                new Line(playersCount, generator),
                new Line(playersCount, generator),
                new Line(playersCount, generator)
        ));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getLines() {
        ArrayList<Line> lineList = new ArrayList<>(List.of(
                new Line(playersCount, generator),
                new Line(playersCount, generator),
                new Line(playersCount, generator),
                new Line(playersCount, generator),
                new Line(playersCount, generator)
        ));
        Lines lines = new Lines(lineList);
        List<Line> actual = lines.getLines();

        assertThat(actual).isEqualTo(lineList);
        assertThatThrownBy(() -> {
            actual.add(new Line(playersCount, generator));
        }).isInstanceOf(UnsupportedOperationException.class);
    }
}