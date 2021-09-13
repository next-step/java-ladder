package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Block;

public class BlockTest {

	@Test
	@DisplayName("사다리 가로선이 연속되면 안됨")
	void test() {
		Block first = new Block(false);

		Block second = first.makeNext(true);

		assertThat(second.isConnected()).isTrue();

		Block third = second.makeNext(true);

		assertThat(third.isConnected()).isFalse();

		Block four = third.makeNext(false);

		assertThat(four.isConnected()).isFalse();

		Block fix = four.makeNext(true);

		assertThat(fix.isConnected()).isTrue();
	}
}
