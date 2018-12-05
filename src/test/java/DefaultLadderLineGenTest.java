import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultLadderLineGenTest {
	
	@Test
	public void getLadderLines() {
		DefaultLadderLineGen defaultLadderLineGen = new DefaultLadderLineGen();
		List<LadderLine> ladderLines = defaultLadderLineGen.getLadderLines(new Positive(4), 5);
		assertThat(ladderLines.size()).isEqualTo(4);
	}
}