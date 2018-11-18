package laddergame.domain.result;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import laddergame.domain.result.Result;
import laddergame.domain.result.Results;
import org.junit.Before;
import org.junit.Test;

public class ResultsTest {

	private Results results;

	@Before
	public void setUp() {
		results = Results.fromComma("꽝,1000,5000");
	}

	@Test
	public void 콤마로_객체_생성() {
		assertThat(results)
				.extracting("results")
				.containsExactly(asList(new Result("꽝"), new Result("1000"), new Result("5000")));
	}

	@Test
	public void 좌표에_해당하는_결과_조회() {
		final int resultIndex = 1;
		assertThat(results.findResult(resultIndex)).isEqualTo(new Result("1000"));
	}
}