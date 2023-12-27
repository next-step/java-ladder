package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ResultsTest {

    @DisplayName("참가자 수와 결과를 담은 배열을 전달하면 Results 객체를 생성한다.")
    @Test
    void resultsTest() {
        assertThat(Results.of(3, new String[]{"꽝", "당첨", "꽝"})).isInstanceOf(Results.class);
    }

    @DisplayName("참가자 수와 결과를 담은 배열의 개수가 다르면 IllegalArgumentException을 던진다.")
    @Test
    void resultsExceptionTest() {
        assertThatThrownBy(() -> Results.of(3, new String[]{"꽝", "당첨"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("인덱스를 전달하면 해당 인덱스에 위치한 결과값을 반환한다.")
    @Test
    void getResultTest() {
        Results results = new Results(List.of("꽝1", "당첨1", "꽝2", "당첨2"));

        assertThat(results.getResult(2)).isEqualTo("꽝2");
    }
}
