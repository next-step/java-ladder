package game.ladder.domain;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLinesTest {

    @Test
    public void 만들기() {
        final int sizeOfPerson = 3;
        final Height height = new Height(5);
        LadderLines ladderLines = new LadderLines(height, sizeOfPerson);

        assertThat(ladderLines.getHeight()).isEqualTo(height);
        assertThat(ladderLines.width()).isEqualTo(sizeOfPerson);
    }

    @Test
    public void 만들기_리스트넘기기() {
        final Point first = Point.first(false);
        final Point last = first.last();

        final LadderLine ladderLine = new LadderLine(ImmutableList.of(first, last));
        final List<LadderLine> ladderLineList = ImmutableList.of(ladderLine, ladderLine);

        LadderLines ladderLines = new LadderLines(ladderLineList);

        assertThat(ladderLines.width()).isEqualTo(ladderLine.pointSize());
        assertThat(ladderLines.getHeight()).isEqualTo(new Height(ladderLineList.size()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 만들기_빈_리스트_넘기기() {
        final List<LadderLine> emptyList = Collections.emptyList();

        new LadderLines(emptyList);
    }

    @Test
    public void getStringLadderLines() {
        final String expected = "     |     |" + System.lineSeparator() +
                                "     |     |" + System.lineSeparator();

        final Point first = Point.first(false);
        final Point last = first.last();

        final LadderLine ladderLine = new LadderLine(ImmutableList.of(first, last));
        final List<LadderLine> ladderLineList = ImmutableList.of(ladderLine, ladderLine);

        LadderLines ladderLines = new LadderLines(ladderLineList);

        String stringLadderLines = ladderLines.getStringLadderLines();
        assertThat(stringLadderLines).isEqualTo(expected);
    }

}