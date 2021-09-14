package nextstep.domain;

import domain.User;
import domain.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class UsersTest {

	private User firstUser;
	private User secondUser;
	private Users users;

	@BeforeEach
	void init() {
		firstUser = new User("민율");
		secondUser = new User("yul");
		users = new Users(Arrays.asList(firstUser, secondUser));
	}

	@DisplayName("Users의 appear 메소드를 테스트")
	@Test
	void test_appear_method() {
		assertThat(users.appear(0)).isEqualTo(firstUser);
	}

	@DisplayName("Users의 사이즈를 테스트")
	@Test
	void test_users_size() {
		assertThat(users.count()).isEqualTo(2);
	}
}
