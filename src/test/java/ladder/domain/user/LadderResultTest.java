package ladder.domain.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LadderResultTest {

    private Map<Username, String> resultMap;

    @BeforeEach
    void setup() {
        resultMap = new HashMap<>();
        resultMap.put(Username.of("john"), "1000");
        resultMap.put(Username.of("alice"), "2000");
    }

    @Test
    @DisplayName("여러명의 결과가 존재하는 경우를 확인한다")
    void test() {
        LadderResult ladderResult = LadderResult.of(resultMap);

        assertFalse(ladderResult.isOneUser());
        assertThat(ladderResult.findAll().get(Username.of("john"))).isEqualTo("1000");
    }

    @Test
    @DisplayName("한명의 결과만 존재하는 경우를 확인한다")
    void checkOneUser() {
        resultMap = new HashMap<>();
        resultMap.put(Username.of("john"), "1000");
        LadderResult ladderResult = LadderResult.of(resultMap);

        assertTrue(ladderResult.isOneUser());
        assertThat(ladderResult.getResultOne()).isEqualTo("1000");
    }
}
