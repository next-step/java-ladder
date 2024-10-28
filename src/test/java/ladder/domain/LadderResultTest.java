package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LadderResultTest {

    @Test
    void 실행_결과_저장_테스트() {
        LadderResult ladderResult = LadderResult.from(new Persons("phobi,doun,leo,bbj"),"꽝,5000,꽝,3000");
        assertThat(ladderResult).isEqualTo(new LadderResult(
                Map.of(0, "꽝", 1, "5000", 2, "꽝", 3, "3000")
        ));
    }

    @Test
    void 실행_결과_실패_테스트() {
        assertThatThrownBy(() -> LadderResult.from(new Persons("phobi,doun,leo"), "꽝,5000,꽝,3000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("입력한 실행 결과 수가 참여자 수를 초과했습니다.");
    }

    @Test
    void 실행_결과_조회_테스트() {
        LadderResult ladderResult = LadderResult.from(new Persons("phobi,bbj"), "꽝,5000");

        assertThat(ladderResult.getResult(0)).isEqualTo("꽝");
        assertThat(ladderResult.getResult(1)).isEqualTo("5000");
    }

}
