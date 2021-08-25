package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MembersTest {

	@DisplayName("Members 객체 생성 테스트")
	@Test
	void membersInitializeTest() {
		Members members = Members.of(Arrays.asList("test", "test2", "test3"));

		assertThat(members.size() == 3).isTrue();
	}
}