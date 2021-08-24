package nextstep.ladder.enums;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderStatusTest {

	@ParameterizedTest
	@CsvSource(value = {"1=true", "2=false"}, delimiter = '=')
	void ladderStatusTest(int value, boolean expected) {
		LadderStatus ladderStatus = LadderStatus.of(value);

		assertThat(ladderStatus.equals(LadderStatus.LINKED)).isEqualTo(expected);
	}

}