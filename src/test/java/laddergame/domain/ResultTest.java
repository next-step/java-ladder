package laddergame.domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class ResultTest {

	@Test
	public void 결과는_플레이어명의_최대길이를_기준으로_오른쪽정렬_출력() {
		Result result1 = new Result("5000");
		Result result2 = new Result("꽝");

		SoftAssertions softAssertions = new SoftAssertions();
		softAssertions.assertThat(result1.getFormattedValue()).as("4자").isEqualTo(" 5000");
		softAssertions.assertThat(result2.getFormattedValue()).as("2자").isEqualTo("    꽝");
		softAssertions.assertAll();
	}
}