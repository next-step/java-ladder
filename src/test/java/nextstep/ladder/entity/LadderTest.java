package nextstep.ladder.entity;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import nextstep.ladder.exception.UserException;
import nextstep.ladder.exception.UserExceptionMesssage;

public class LadderTest {

	@ParameterizedTest
	@DisplayName("숫자가 음수인 경우 exception")
	@ValueSource(ints = {-1, -2, -3, -4})
	void ladder_Exception(int input) {
		assertThatExceptionOfType(UserException.class)
			.isThrownBy(() -> {
				new Ladder(new Users("1,2,3,4"), input);
			})
			.withMessageMatching(UserExceptionMesssage.NEGATIVE_NOT_AGRRESIVE.getMessage());
	}

	@Test
	void LadderTest() {
		Ladder ladder = new Ladder(new Users("a,b,c,d,e"), 3);
		System.out.println(ladder);
		ladder.getUsers().getUsers().forEach(
			user -> {
				System.out.println(user.getName() + " " + user.getPosition());
			}
		);
		Ladder ladder2 = ladder.moveLadder();
		System.out.println(ladder2);



		ladder2.getUsers().getUsers().forEach(
			user -> System.out.println(user.getName() + " " + user.getPosition())
		);
	}
}
