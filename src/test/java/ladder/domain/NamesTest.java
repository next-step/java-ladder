package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NamesTest {

	@DisplayName("참여할 사람 등록")
	@Test
	void test1() {
		Names names = new Names("pobi,honux,crong,jk");
		assertThat(names).isEqualTo(new Names("pobi,honux,crong,jk"));
	}
}
