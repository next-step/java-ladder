package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.LadderResultDeterminer;
import nextstep.ladder.domain.Names;

class LadderResultDeterminerTest {

	@Test
	@DisplayName("실행 결과의 개수가 참여자의 수와 일치하지 않으면 예외가 발생한다")
	void testResultNumber() {
		final String[] result = {"꽝", "5000", "꽝"};
		final String[] names = {"pobi", "crong"};

		assertThatIllegalArgumentException().isThrownBy(() -> new LadderResultDeterminer(new LadderResult(result),
			new Ladder(4, new Height(5)), new Names(names)));
	}

	@Test
	@DisplayName("실행 결과의 개수가 참여자의 수와 일치하면 객체가 생성된다")
	void testResultNumber2() {
		final String[] result = {"꽝", "5000"};
		final String[] names = {"pobi", "crong"};

		assertThatNoException().isThrownBy(() -> new LadderResultDeterminer(new LadderResult(result),
			new Ladder(4, new Height(5)), new Names(names)));
	}
}