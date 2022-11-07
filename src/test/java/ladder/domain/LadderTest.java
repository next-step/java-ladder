package ladder.domain;

import ladder.dto.InputDTO;
import ladder.view.OutputView;
import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.function.BooleanSupplier;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by seungwoo.song on 2022-11-04
 */
class LadderTest {

	@Test
	void 생성() {
		int rowCount = 2;
		int personCount = 3;
		BooleanSupplier booleanSupplier = () -> true;

		Ladder ladder = Ladder.of(rowCount, personCount, booleanSupplier);

		assertThat(ladder).isEqualTo(Ladder.of(rowCount, personCount, booleanSupplier));
	}

	@Test
	void invalid() {
		assertThatIllegalArgumentException().isThrownBy(() -> Ladder.of(-1, -1, null));
	}

	@ParameterizedTest
	@CsvSource(value = {"0:1","1:0","2:2"}, delimiter = ':')
	void 이동(int startIndex, int expectedResultIndex) {
		/*
		0   1     2
		true false
		true false
		true false
		 */
		int rowCount = 3;
		int personCount = 3;
		BooleanSupplier booleanSupplier = () -> true;

		Ladder ladder = Ladder.of(rowCount, personCount, booleanSupplier);
		int resultIndex = ladder.getResultIndex(startIndex);

		assertThat(resultIndex).isEqualTo(expectedResultIndex);
	}
}