package nextstep.study3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study2.domain.RandomGenerator;

class RandomGeneratorTest {

	RandomGenerator randomGenerator = new RandomGenerator();
	
	@Test
	@DisplayName("랜덤생성기 테스트")
	void 랜덤제너레이터는_트루나_폴스값만받는다() {
		boolean trueOrfalse = randomGenerator.getRandom();
		
		assertThat(trueOrfalse).isNotNull()
								.isTrue();
	}

}
