package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ResultsTest {

    private static final int HEIGHT = 5;

    private Results results;

    @BeforeEach
    void setUp() {
        results = Results.toResults("꽝,5000,꽝,3000", HEIGHT);
    }

    @DisplayName("결과에 공백이 포함되 있을경우 에러를 던진다.")
    @Test
    void 결과_공백시_에러() {
        assertThatThrownBy(() -> Results.toResults("꽝,  ,꽝,3000", HEIGHT)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("꽝,5000,꽝,3000 파라미터로 Results 클래스 생성 시 4개에 결과가 존재해야 한다.")
    @Test
    void 결과_갯수_검증() {
        assertThat(Results.toResults("꽝,5000,꽝,3000", HEIGHT).results().size()).isEqualTo(4);
    }

    @ParameterizedTest(name = "꽝,5000,꽝,3000 파라미터로 Results 클래스 생성 시 각각 Position을 보유해야하며" +
            "파라미터로 넘긴 포지션과 일치해야한다.")
    @CsvSource(value = {
            "0|5|꽝",
            "1|5|5000",
            "2|5|꽝",
            "3|5|3000",
    }, delimiter = '|')
    void 라인_이동_위치_검증(int x, int y, String result) {
        assertThat(results.reuslt(new Position(x, y))).isEqualTo(result);
    }

}