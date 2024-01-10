package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public final class PeopleTest {
	@Test
	@DisplayName("사람이 두명 이하면 에러를 던진다")
	void 사람_수_에러() {
		assertThatThrownBy(() -> new People(new ArrayList<>(List.of("a")))).isInstanceOf(InputMismatchException.class);
	}

	@Test
	@DisplayName("입력한 사람 수만큼 count하는지 확인")
	void 사람_수_확인() {
		List<String> nameList = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
		People people = new People(nameList);

		assertThat(people.count()).isEqualTo(4);
	}
}
