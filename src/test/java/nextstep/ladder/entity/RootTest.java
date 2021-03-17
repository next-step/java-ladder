package nextstep.ladder.entity;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RootTest {

	@Test
	void Root_데이터_true() {
		assertThat(new Root(() -> true).getRoot())
			.isEqualTo(true);
	}

	@Test
	void Root_데이터_false() {
		assertThat(new Root(() -> false).getRoot())
			.isEqualTo(false);
	}
}
