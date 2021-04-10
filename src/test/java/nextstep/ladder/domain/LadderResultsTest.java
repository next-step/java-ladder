package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LadderResultsTest {
    private Ladder ladder;
    private Results results;

    @BeforeEach
    void setUp() {
        List<Line> lines = new ArrayList<Line>(){
            {
                add(new Line(4, () -> true));
                add(new Line(4, () -> false));
                add(new Line(4, () -> false));
                add(new Line(4, () -> false));
            }
        };
        ladder = new Ladder(lines);
        results = Results.from("꽝,5000,꽝,3000");
    }

    @Test
    @DisplayName(value = "사다리 결과 객체 생성")
    void ladderResultsArgumentException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new LadderResults(ladder, Results.from(""));
                }).withMessageMatching("사다리 결과는 사다리 참가자 수와 같아야 합니다.");
    }

    @ParameterizedTest
    @DisplayName(value = "사다리 실행 결과 확인")
    @CsvSource(value = {"0:5000", "1:꽝", "2:3000", "3:꽝"}, delimiter = ':')
    void ladderResult(int startPosition, String result) {
        LadderResults ladderResults = new LadderResults(ladder, results);

        assertThat(ladderResults.getLadderResult(startPosition))
                .isEqualTo(result);
    }
}