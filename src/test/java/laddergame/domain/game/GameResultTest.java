package laddergame.domain.game;

import laddergame.domain.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameResultTest {

    private static Stream<Arguments> provideNameAndResult() {
        return Stream.of(Arguments.of("pobi", new Prize("꽝", 2)),
                Arguments.of("crong", new Prize("2000", 1)),
                Arguments.of("horox", new Prize("꽝", 3)));
    }

    private static Map<Player, Prize> createResultMap() {
        Map<Player, Prize> results = new HashMap<>();

        results.put(new Player("pobi", 1), new Prize("꽝", 2));
        results.put(new Player("crong", 2), new Prize("2000", 1));
        results.put(new Player("horox", 3), new Prize("꽝", 3));

        return results;
    }

    @DisplayName("이름으로 결과를 찾는다.")
    @ParameterizedTest
    @MethodSource("provideNameAndResult")
    void findByName(String findName, Prize findPrize) {
        GameResult gameResult = new GameResult(createResultMap());

        Prize actualPrize = gameResult.findByName(findName);

        assertThat(actualPrize.getName()).isEqualTo(findPrize.getName());
    }

    @DisplayName("없는 이름으로 결과를 찾으면 IllegalArgumentException throw")
    @Test
    void findByWrongName() {
        GameResult gameResult = new GameResult(createResultMap());
        String wrongName = "min";

        assertThatThrownBy(() -> gameResult.findByName(wrongName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지않는 이름입니다. - " + wrongName);
    }
}