package cc.oakk.ladder.model;

import cc.oakk.ladder.model.ladder.Ladder;
import cc.oakk.ladder.model.ladder.dto.LadderDto;
import cc.oakk.ladder.model.line.Line;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    public void initLines() {
        Ladder ladder = new Ladder(5, 5);
        Line comparingLine = new Line(5);
        comparingLine.connect(1);
        comparingLine.connect(3);

        ladder.initLines(l -> new int[] { 1, 3 }).getLines()
                .forEach(v -> assertThat(v).isEqualTo(comparingLine));
    }

    @Test
    public void getDto() {
        Ladder ladder = new Ladder(5, 5);
        ladder.initLines(l -> new int[] { 1, 3 });

        Line comparingLine = new Line(5);
        comparingLine.connect(1);
        comparingLine.connect(3);

        LadderDto ladderDto = new LadderDto(IntStream.range(0, 5).boxed()
                .map(v -> comparingLine.getDto())
                .collect(Collectors.toList()));

        assertThat(ladder.getDto()).isEqualTo(ladderDto);
    }
}
