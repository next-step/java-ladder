package nextstep.study2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study2.domain.RandomGenerator;

class RandomGeneratorTest {

	@Test
	@DisplayName("랜덤생성기 테스트")
	void 랜덤제너레이터는_트루나_폴스값만받는다() {
		boolean trueOrfalse = RandomGenerator.randomGenratoring();
		
		assertThat(trueOrfalse).isNotNull()
								.isTrue();
	}

}
