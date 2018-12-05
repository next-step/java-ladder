import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositiveTest {
	
	@Test
	public void newPositive() {
		Positive positive = new Positive(5);
		assertThat(positive.getValue()).isEqualTo(5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void newPositive_error() {
		Positive positive = new Positive(-1);
	}
}