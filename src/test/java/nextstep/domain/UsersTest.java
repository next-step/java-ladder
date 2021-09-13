package nextstep.domain;

import domain.User;
import domain.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class UsersTest {

	@DisplayName("Users의 appear 메소드를 테스트")
	@Test
	void test_users_size() {
		User firstUser = new User("민율");
		User secondUser = new User("yul");
		Users users = new Users(Arrays.asList(firstUser, secondUser));
		assertThat(users.appear(0)).isEqualTo(firstUser);
	}
}
