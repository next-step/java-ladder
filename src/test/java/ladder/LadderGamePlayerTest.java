package ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import ladder.domain.Ladder;
import ladder.domain.Rewards;
import ladder.domain.exception.UnknownNameException;
import ladder.domain.line.BarHelper;
import ladder.domain.line.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderGamePlayerTest {

    @ParameterizedTest
    @DisplayName("사다리게임 실행")
    @MethodSource("getMatchData")
    void play_by_command_name(String name, String expected) {
        Ladder ladder = getLadder();
        Rewards rewards = getRewards();

        LadderGamePlayer gamePlayer = new LadderGamePlayer();

        Map<String, String> resultByName = gamePlayer.play(new LadderGameData(ladder, rewards),
                        name)
                .getResult();

        Map<String, String> resultByAll = gamePlayer.play(new LadderGameData(ladder, rewards),
                        "all")
                .getResult();

        assertAll(
                () -> assertThat(resultByName.size()).isEqualTo(1),
                () -> assertThat(resultByName.get(name)).isEqualTo(expected),
                () -> assertThat(resultByAll.size()).isEqualTo(4),
                () -> assertThat(resultByAll.get(name)).isEqualTo(expected)
        );
    }

    @Test
    @DisplayName("사다리게임 실행 시 없는 이름을 입력하면 예외 발생")
    void fail_to_play_by_unknown_name() {
        Ladder ladder = getLadder();
        Rewards rewards = getRewards();

        LadderGamePlayer gamePlayer = new LadderGamePlayer();

        assertThatExceptionOfType(UnknownNameException.class)
                .isThrownBy(() -> gamePlayer.play(new LadderGameData(ladder, rewards), "king"));
    }

    private Ladder getLadder() {
        return new Ladder(
                List.of("pobi", "honux", "crong", "jk"),
                5,
                List.of(
                        new Line(4, BarHelper.getBars(List.of(false, false, true, false))),
                        new Line(4, BarHelper.getBars(List.of(false, true, false, true))),
                        new Line(4, BarHelper.getBars(List.of(false, true, false, false))),
                        new Line(4, BarHelper.getBars(List.of(false, false, true, false))),
                        new Line(4, BarHelper.getBars(List.of(false, true, false, true)))
                ));
    }

    private Rewards getRewards() {
        return new Rewards(List.of("꽝", "5000", "꽝", "3000"), 4);
    }

    private static Stream<Arguments> getMatchData() {
        return Stream.of(
                Arguments.arguments(
                        "pobi",
                        "5000"
                ),
                Arguments.arguments(
                        "honux",
                        "꽝"
                ),
                Arguments.arguments(
                        "crong",
                        "3000"
                ),
                Arguments.arguments(
                        "jk",
                        "꽝"
                )
        );
    }

}
