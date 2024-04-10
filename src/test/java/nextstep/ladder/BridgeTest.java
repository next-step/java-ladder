package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import nextstep.ladder.domain.Bridge;

public class BridgeTest {

	@ParameterizedTest
	@CsvSource(value = {"true,BRIDGE", "false,NON_BRIDGE"})
	@DisplayName("랜덤으로 선택된 boolean 값으로 다리 생성 여부를 판단한다")
	void createBridge(final boolean isBridge, final Bridge expected) {
		final Bridge bridge = Bridge.of(isBridge);

		assertThat(bridge).isEqualTo(expected);
	}
}
