package game.ladder.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    @Test
    public void 만들기() {
        List<Line> inputs = Arrays.asList(Line.of(3));
        Lines lines = new Lines(inputs);

        assertThat(lines.getHeight()).isEqualTo(new Height(inputs.size()));
    }

    @Test
    public void 최종_위치() {
        final Line line1 = Line.customLine(
                Arrays.asList(Block.EMPTY_BLOCK, Block.FILLED_BLOCK, Block.EMPTY_BLOCK, Block.EMPTY_BLOCK, Block.EMPTY_BLOCK)
        );
        final Line line2 = Line.customLine(
                Arrays.asList(Block.EMPTY_BLOCK, Block.EMPTY_BLOCK, Block.FILLED_BLOCK, Block.EMPTY_BLOCK, Block.EMPTY_BLOCK)
        );

        Lines lines = new Lines(Arrays.asList(line1, line2));

        Position position1 = lines.computeResultPosition(new Position(1));
        Position position2 = lines.computeResultPosition(new Position(2));
        Position position3 = lines.computeResultPosition(new Position(3));
        Position position4 = lines.computeResultPosition(new Position(4));

        assertThat(position1).isEqualTo(new Position(3));
        assertThat(position2).isEqualTo(new Position(1));
        assertThat(position3).isEqualTo(new Position(2));
        assertThat(position4).isEqualTo(new Position(4));
    }

    @Test
    public void getStringLines() {
        final String exected = "     |-----|     "+System.lineSeparator()+"     |-----|     "+System.lineSeparator();
        final Line line = Line.customLine(Arrays.asList(Block.EMPTY_BLOCK, Block.FILLED_BLOCK));

        Lines lines = new Lines(Arrays.asList(line, line));

        assertThat(lines.getStringLines()).isEqualTo(exected);
    }
}