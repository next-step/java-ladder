import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LevelLadderLineGeneratorTest {

    @Test
    public void getLadderLines_상() {
        LevelLadderLineGenerator ladderLineGenerator = new LevelLadderLineGenerator(Level.상);
        List<LadderLine> ladderLines = ladderLineGenerator.getLadderLines(5);
        assertThat(ladderLines.size()).isEqualTo(Level.상.getHeight().getValue());
    }

    @Test
    public void getLadderLines_중() {
        LevelLadderLineGenerator ladderLineGenerator = new LevelLadderLineGenerator(Level.중);
        List<LadderLine> ladderLines = ladderLineGenerator.getLadderLines(5);
        assertThat(ladderLines.size()).isEqualTo(Level.중.getHeight().getValue());
    }


    @Test
    public void getLadderLines_하() {
        LevelLadderLineGenerator ladderLineGenerator = new LevelLadderLineGenerator(Level.하);
        List<LadderLine> ladderLines = ladderLineGenerator.getLadderLines(5);
        assertThat(ladderLines.size()).isEqualTo(Level.하.getHeight().getValue());
    }
}