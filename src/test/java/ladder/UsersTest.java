package ladder;

import ladder.domain.user.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class UsersTest {
	@DisplayName(",을 구분으로 한 사용자 이름들을 입력받아 사용자들을 생성한다.")
	@Test
	void createUsers() {
		// given
		String userNames = "pobi,crong,honux";

		// when
		Users users = Users.createUsers(userNames);

		// then
		assertThat(users.getUsers()).extracting("name", String.class).contains("pobi", "crong", "honux");
	}
}
