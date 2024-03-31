package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

public class LadderResultTest {

    @ParameterizedTest
    @ValueSource(strings = {"1000", "3000", "꽝"})
    @DisplayName("put 호출 시 Player를 key로, 결과 문자열을 value로 Map에 추가")
    void put(String result) {
        Map<Player, String> resultMap = new HashMap<>();
        Player pobi = Player.of("pobi", 0);
        resultMap.put(pobi, result);
        LadderResult ladderResult = new LadderResult(resultMap);
        Assertions.assertThat(ladderResult.getResult(pobi)).isEqualTo(result);
    }
}
