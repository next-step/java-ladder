package laddergame.v2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderResultTest {
    
    @DisplayName("최종 위치와 매칭되는 사다리 결과를 조회한다")
    @Test
    void get(){
        LadderResult result = new LadderResult(List.of("꽝", "당첨", "꽝"));

        assertThat(result.get(0)).isEqualTo("꽝");
        assertThat(result.get(1)).isEqualTo("당첨");
        assertThat(result.get(2)).isEqualTo("꽝");
    }
}
