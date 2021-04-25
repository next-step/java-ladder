package nextstep.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {
    @Test
    @DisplayName("기본테스트")
    void classDefault() {
        LadderResult ladderResult1 = new LadderResult(Arrays.asList("bong", "big", "il", "gyun"), "꽝,5000,꽝,3000");
        assertThat(ladderResult1.size()).isEqualTo(4);

        LadderResult ladderResult2 = new LadderResult(Arrays.asList("bong", "big", "il", "gyun"), "꽝,5000,꽝,3000");
        assertThat(ladderResult2.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("all 결과출력위한 테스트")
    void keytest() {
        Map<Player, String> result = new HashMap<>();
        result.put(new Player("bong"), "111");
        result.put(new Player("big"), "222");
        LadderResult ladderResult = new LadderResult("bong,big", "111, 222");
        String actual = ladderResult.allResult();
        System.out.println("actual = " + actual);
        assertThat(actual).isEqualTo("bong : 111\nbig : 222\n");
    }
}
