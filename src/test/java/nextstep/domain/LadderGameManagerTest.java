package nextstep.domain;

import nextstep.domain.ladder.LadderGameManager;
import nextstep.domain.line.strategy.SwitchDrawTransverseBarStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 게임 매니저")
public class LadderGameManagerTest {

    @DisplayName("다음 트랙 번호 구하기")
    @ParameterizedTest
    @MethodSource("getNextTrackNumberMethod")
    public void getNextTrackNumber(int lineNumber, int trackNumber, int result) {
        LadderGameManager ladderGameManager = new LadderGameManager(5, 5, new SwitchDrawTransverseBarStrategy());
        assertThat(ladderGameManager.getNextTrackNumber(lineNumber, trackNumber)).isEqualTo(result);
    }

    private static Stream<Arguments> getNextTrackNumberMethod() {
        return Stream.of(
                Arguments.of(0, 0, 1),
                Arguments.of(0, 1, 0),
                Arguments.of(0, 2, 3),
                Arguments.of(0, 3, 2),
                Arguments.of(0, 4, 4)
        );
    }

}
