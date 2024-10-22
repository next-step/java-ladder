package laddergame.v1.domain;

import laddergame.v1.domain.LadderResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

    @DisplayName("사다리의 위치에 연결된 게임 결과를 조회한다")
    @Test
    void getResultByPosition(){
        List<String> result = List.of("꽝", "성공", "꽝");
        LadderResult mapping = new LadderResult(result);

        assertThat(mapping.findBy(0)).isEqualTo("꽝");
        assertThat(mapping.findBy(1)).isEqualTo("성공");
        assertThat(mapping.findBy(2)).isEqualTo("꽝");
    }

}