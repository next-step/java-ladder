package step4.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UsersTest {
	private Users users;
	private String beforeUser1;
	private String beforeUser2;

	@BeforeEach
	void set() {
		users = new Users(new String[] {"dam", "co", "mong"});
		beforeUser1 = users.getUsers().get(0).toString();
		beforeUser2 = users.getUsers().get(1).toString();
	}

	@DisplayName(value = "사다리 라인이 있을 경우 유저 위치 변경 테스트")
	@Test
	void swapUser() {
		users.move(1, true);
		String afterUser1 = users.getUsers().get(0).toString();
		String afterUser2 = users.getUsers().get(1).toString();

		assertThat(beforeUser1).isEqualTo(afterUser2);
		assertThat(beforeUser2).isEqualTo(afterUser1);
	}

	@DisplayName(value = "사다리 라인이 없을 경우 유저 위치 고정 테스트")
	@Test
	void stayUser() {
		users.move(1, false);
		String afterUser1 = users.getUsers().get(0).toString();
		String afterUser2 = users.getUsers().get(1).toString();

		assertThat(beforeUser1).isEqualTo(afterUser1);
		assertThat(beforeUser2).isEqualTo(afterUser2);
	}
}
