package nextstep.ladder.domain.result;

import nextstep.ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {

    @DisplayName("결과 리스트를 생성한다.")
    @Test
    void creatResultsTest() {
        Results.from("꽝,5000,꽝,3000");
    }

    @DisplayName("특정 위치의 결과를 반환한다.")
    @Test
    void resultTest() {
        Results results = Results.from("꽝,5000,꽝,3000");
        assertThat(results.result(Position.from(2)))
                .isEqualTo(new Result(Position.from(2), "꽝"));
    }

    @DisplayName("결과 리스트의 크기를 반환한다.")
    @Test
    void sizeTest() {
        Results results = Results.from("꽝,5000,꽝,3000");
        assertThat(results.size()).isEqualTo(4);
    }
}