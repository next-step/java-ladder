package ladder.domain.user;

import ladder.domain.ladder.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;


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

	@DisplayName("중복 참여자가 있으면 예외처리가 발생한다.")
	@Test
	public void createDuplicateUsers() {
		//given
		String userNames = "pobi,pobi,honux";

		//when
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					Users.createUsers(userNames);
				}).withMessageMatching("유저이름은 중복될 수 없습니다.");
	}
}
