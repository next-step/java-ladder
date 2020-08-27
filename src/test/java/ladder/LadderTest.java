package ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderArgument;
import ladder.domain.ladder.LadderFactory;
import ladder.domain.ladder.Names;

public class LadderTest {

	@Test
	public void ladderCreateTest() {
		LadderArgument argument = LadderArgument.of(Names.of("lupy, poby, eddy, petty"), 7);
		Ladder ladder = LadderFactory.create(argument);

		assertThat(argument.getWidth()).isEqualTo(4);
		assertThat(ladder).isNotNull();
	}

	@Test
	public void ladderHeightExceptionTest() {
		assertThatThrownBy(() -> LadderArgument.of(Names.of("lupy, poby, eddy, petty"), 0))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("사다리의 높이는 0 보다 큰 숫자로 입력해주세요.");
	}

	@Test
	public void nameEmptyExceptionTest() {
		assertThatThrownBy(() -> LadderArgument.of(Names.of(""), 5))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("이름을 입력해주세요.");
	}

	@Test
	public void oneNameExceptionTest() {
		assertThatThrownBy(() -> LadderArgument.of(Names.of("lupy"), 5))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("이름은 두명 이상 입력해주세요.");
	}

	@Test
	public void nameLengthExceptionTest() {
		assertThatThrownBy(() -> LadderArgument.of(Names.of("lupy, pororo"), 5))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("이름은 5글자 이내로 입력해주세요.");
	}
}
