package ladder.domain;

import ladder.exception.OutOfRailNumberException;
import ladder.test_double.PredefinedStepProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class HorizontalNodeListTest {

	int sampleRailCount = 5;

	StepProvider sampleStepProvider;

	@BeforeEach
	void arrangeSample(){
		this.sampleStepProvider = new PredefinedStepProvider(Arrays.asList(true, false, false, true)); // |-| | |-|
	}

	@Test
	void createNormalRow() {
		HorizontalNodeList row = new HorizontalNodeList(sampleRailCount, sampleStepProvider);

		assertThat(row.getNextRailFrom(0)).isEqualTo(1);
		assertThat(row.getNextRailFrom(1)).isEqualTo(0);
		assertThat(row.getNextRailFrom(2)).isEqualTo(2);
		assertThat(row.getNextRailFrom(3)).isEqualTo(4);
		assertThat(row.getNextRailFrom(4)).isEqualTo(3);

	}

	@DisplayName("연속적으로 가로 계단을 공급하면 뒤에 추가되는 것은 무시")
	@Test
	void createWithContinuedStepRow() {
		int railCount = 3;

		StepProvider provider = new PredefinedStepProvider(Arrays.asList(true, true)); // |-| |
		HorizontalNodeList row = new HorizontalNodeList(railCount, provider);

		assertThat(row.getNextRailFrom(0)).isEqualTo(1);
		assertThat(row.getNextRailFrom(1)).isEqualTo(0);
		assertThat(row.getNextRailFrom(2)).isEqualTo(2);
	}

	@DisplayName("생성한 레일개수보다 큰 레일번호의 가로계단 체크시도")
	@Test
	void checkStepOverRails() {
		HorizontalNodeList row = new HorizontalNodeList(sampleRailCount, sampleStepProvider);

		assertThatExceptionOfType(OutOfRailNumberException.class).isThrownBy(() -> row.getNextRailFrom(-1));
		assertThatExceptionOfType(OutOfRailNumberException.class).isThrownBy(() -> row.getNextRailFrom(5));
	}

	@DisplayName("다음열 레일번호 반환")
	@Test
	void checkNextRowRailNumber() {
		HorizontalNodeList row = new HorizontalNodeList(sampleRailCount, sampleStepProvider);

		assertThat(row.getNextRailFrom(0)).isEqualTo(1);
		assertThat(row.getNextRailFrom(1)).isEqualTo(0);
		assertThat(row.getNextRailFrom(2)).isEqualTo(2);
		assertThat(row.getNextRailFrom(3)).isEqualTo(4);
		assertThat(row.getNextRailFrom(4)).isEqualTo(3);
	}

}