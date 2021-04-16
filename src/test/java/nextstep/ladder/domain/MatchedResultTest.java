package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.BDDAssertions.then;

public class MatchedResultTest {
    private Map<String, String> map;
    private MatchedResult matchedResult;

    @BeforeEach
    void setUp() {
        map = new LinkedHashMap<>();
        map.put("pobi", "꽝");
        map.put("dobi", "당첨");
        matchedResult = new MatchedResult(map);
    }

    @Test
    @DisplayName("플레이어의 이름을 인자로 받아 해당 이름이 매핑 결과에 저장되어 있을 경우 참을 반환한다.")
    public void containsKey() throws Exception {
        //when
        boolean result = matchedResult.containsKey("pobi");

        then(result).isTrue();
    }

    @Test
    @DisplayName("플레이어의 이름을 인자로 받아 해당하는 플레이어 매핑되는 결과 값을 반환한다.")
    public void get() throws Exception {
        //when
        String result = matchedResult.get("pobi");

        then(result).isEqualTo("꽝");
    }

    @Test
    @DisplayName("입력받은 플레이어 이름에 대한 매핑 결과가 없을 시에 예외가 발생한다.")
    public void validateInvalidTarget() throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> matchedResult.containsKey("none"));
    }

    @Test
    @DisplayName("입력받은 플레이어 이름이 \"all\"일 경우 참을 반환한다.")
    public void isAll() throws Exception {
        //when
        boolean result = matchedResult.isAll("all");

        then(result).isTrue();
    }
}
