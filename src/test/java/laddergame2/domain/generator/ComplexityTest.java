package laddergame2.domain.generator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ComplexityTest {

	@Test
	public void 이름에_해당하는_복잡도_찾기() {
		Complexity complexity = Complexity.from("상");

		assertThat(complexity).isEqualTo(Complexity.HIGH);
	}

	@Test(expected = IllegalArgumentException.class)
	public void 존재하지않는_복잡도() {
		Complexity.from("상중하");
	}

	@Test
	public void 생성_확률() {
		assertThat(Complexity.HIGH.canGenerate(50)).isTrue();
	}
}