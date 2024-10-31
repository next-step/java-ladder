package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LadderPlayResultTest {

    @Test
    void 플레이어_게임_결과_저장_조회_테스트() {
        Map<Person, String> result = new LinkedHashMap<>();
        Person person = new Person("bbj", 0);
        result.put(person, "꽝");
        LadderPlayResult ladderPlayResult = new LadderPlayResult(result);

        assertThat(ladderPlayResult.get(person)).isEqualTo("꽝");
    }

}
