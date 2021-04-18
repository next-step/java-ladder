package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultsTest {

    @DisplayName("LadderResults 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        String[] results = "꽝,5000,꽝,3000".split(",");

        // when
        LadderResults ladderResults = LadderResults.of(results);

        // then
        assertThat(ladderResults).isNotNull();
    }
}