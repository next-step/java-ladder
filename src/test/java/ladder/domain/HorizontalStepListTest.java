package ladder.domain;

import ladder.exception.OutOfRailNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class HorizontalStepListTest {


	int sampleRailCount = 5;

	StepProvider sampleStepProvider;


	@BeforeEach
	void arrangeSample(){
		this.sampleStepProvider = new PredefinedStepProvider(Arrays.asList(true, false, false, true)); // |-| | |-|
	}

	@Test
	void createNormalRow() {

		HorizontalStepList row = new HorizontalStepList(sampleRailCount, sampleStepProvider);

		assertThat(row.hasLeftStepAt(0)).isFalse();	// 왼쪽 첫번째는 완쪽 계단을 가질 수 없다.
		assertThat(row.hasRightStepAt(0)).isTrue();

		assertThat(row.hasLeftStepAt(1)).isTrue();
		assertThat(row.hasRightStepAt(1)).isFalse();

		assertThat(row.hasLeftStepAt(2)).isFalse();
		assertThat(row.hasRightStepAt(2)).isFalse();

		assertThat(row.hasLeftStepAt(3)).isFalse();
		assertThat(row.hasRightStepAt(3)).isTrue();

		assertThat(row.hasLeftStepAt(4)).isTrue();
		assertThat(row.hasRightStepAt(4)).isFalse();

	}

	@DisplayName("연속적으로 가로 계단을 공급하면 뒤에 추가되는 것은 무시")
	@Test
	void createWithContinuedStepRow() {

		int railCount = 3;

		HorizontalStepList row = new HorizontalStepList(5, new PredefinedStepProvider(Arrays.asList(true, true)));

		assertThat(row.hasLeftStepAt(1)).isTrue();
		assertThat(row.hasRightStepAt(1)).isFalse();

	}

	@DisplayName("생성한 레일개수보다 큰 레일번호의 가로계단 체크시도")
	@Test
	void checkStepOverRails() {

		HorizontalStepList row = new HorizontalStepList(sampleRailCount, sampleStepProvider);

		assertThatExceptionOfType(OutOfRailNumberException.class).isThrownBy(() -> row.hasLeftStepAt(-1));
		assertThatExceptionOfType(OutOfRailNumberException.class).isThrownBy(() -> row.hasRightStepAt(5));

	}

	@DisplayName("다음열 레일번호 반환")
	@Test
	void checkNextRowRailNumber() {

		HorizontalStepList row = new HorizontalStepList(sampleRailCount, sampleStepProvider);

		assertThat(row.getNextRailFrom(0)).isEqualTo(1);
	}

}