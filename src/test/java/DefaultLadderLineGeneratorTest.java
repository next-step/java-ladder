import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultLadderLineGeneratorTest {
	
	@Test
	public void getLadderLines() {
		DefaultLadderLineGenerator defaultLadderLineGenerator = new DefaultLadderLineGenerator();
		List<LadderLine> ladderLines = defaultLadderLineGenerator.getLadderLines(new Positive(4), 5);
		assertThat(ladderLines.size()).isEqualTo(4);
	}
}