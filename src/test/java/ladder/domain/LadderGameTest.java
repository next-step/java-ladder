package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.result.Result;
import ladder.exception.LadderGameDifferentSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@DisplayName("사다리게임 테스트")
class LadderGameTest {

    static Stream<Arguments> provideLadderGame() {
        LadderGame ladderGame = new LadderGame(
                Arrays.asList("user1", "user2", "user3"),
                Arrays.asList("result1", "result2", "result3")
        );

        return Stream.of(
                Arguments.of(ladderGame, 1, "user1", Result.valueOf("result2")),
                Arguments.of(ladderGame, 2, "user1", Result.valueOf("result1")),
                Arguments.of(ladderGame, 5, "user3", Result.valueOf("result3"))
        );
    }

    @ParameterizedTest(name = "{2} => {3}")
    @MethodSource("provideLadderGame")
    @DisplayName("사다리 게임 실행 후 결과 값 확인")
    void ladderGameExecuteResultCheck(LadderGame ladderGame, int ladderHeight, String user, Result result) {
        // given
        Ladder ladder = ladderGame.generateLadder(ladderHeight, () -> true);
        LadderGameResult ladderGameResult = ladderGame.execute(ladder);

        // when
        Result actual = ladderGameResult.getLadderGameResult(user);

        // then
        assertThat(actual).isEqualTo(result);
    }

    @ParameterizedTest(name = "사다리 높이 = {1}")
    @MethodSource("provideLadderGame")
    @DisplayName("사다리게임에서 사다리 생성 후 사다리 높이 확인")
    void generateLadderHeightCheck(LadderGame ladderGame, int ladderHeight) {
        // given
        Ladder ladder = ladderGame.generateLadder(ladderHeight, () -> true);

        // when
        int actual = ladder.getLines().size();

        // then
        assertThat(actual).isEqualTo(ladderHeight);
    }

    @Test
    @DisplayName("유저 수와 결과 수 크기가 같지 않다면 Exception")
    void ladderGameArgumentDifferentInSizeException() {
        // given
        List<String> users = Arrays.asList("user1", "user2", "user3");
        List<String> results = Arrays.asList("result1", "result2");

        // when
        // then
        assertThatThrownBy(() -> new LadderGame(users, results))
                .isInstanceOf(LadderGameDifferentSizeException.class);
    }
}