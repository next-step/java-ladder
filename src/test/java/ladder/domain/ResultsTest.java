package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class ResultsTest {

    public final static Results results = new Results(2, List.of("꽝", "1000"));

    @Test
    @DisplayName("인덱스로 결과 값 찾기")
    void findName_success() {
        // given
        int playerIndex = 0;

        // when
        String result = results.findName(playerIndex);

        // then
        assertThat(result).isEqualTo("꽝");
    }
}
