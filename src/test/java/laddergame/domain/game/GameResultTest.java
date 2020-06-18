package laddergame.domain.game;

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
import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {

    private static Stream<Arguments> provideNameAndResult() {
        return Stream.of(Arguments.of("pobi", new Result("꽝", 2)),
                Arguments.of("crong", new Result("2000", 1)),
                Arguments.of("horong", new Result("꽝", 3)));
    }

    private static Map<String, Result> createResultMap() {
        Map<String, Result> resultMap = new HashMap<>();

        resultMap.put("pobi", new Result("꽝", 2));
        resultMap.put("crong", new Result("2000", 1));
        resultMap.put("horong", new Result("꽝", 3));

        return resultMap;
    }

    @DisplayName("이름으로 결과를 찾는다.")
    @ParameterizedTest
    @MethodSource("provideNameAndResult")
    void findByName(String findName, Result findResult) {
        GameResult gameResult = new GameResult(createResultMap());

        Result actualResult = gameResult.findByName(findName);

        assertThat(actualResult.getName()).isEqualTo(findResult.getName());
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