import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultLadderLineGeneratorTest {
	
	@Test
	public void getLadderLines() {
		DefaultLadderLineGenerator defaultLadderLineGenerator = new DefaultLadderLineGenerator(new Positive(4));
		List<LadderLine> ladderLines = defaultLadderLineGenerator.getLadderLines(5);
		assertThat(ladderLines.size()).isEqualTo(4);
	}
}