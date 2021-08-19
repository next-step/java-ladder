package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTests {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        List<String> resultsList = new ArrayList<>(Arrays.asList("꽝", "5000", "꽝", "3000"));
        Results results = Results.of(resultsList);

        assertThat(results).isEqualTo(Results.of(Arrays.asList("꽝", "5000", "꽝", "3000")));
    }

    @DisplayName("최종 위치들 객체 에게 결과들을 줬을 때 위치들에 맞게 올바른 결과 객체를 리턴 해주는지 테스트")
    @Test
    void makeResultsTest() {

        List<String> resultsList = new ArrayList<>(Arrays.asList("꽝", "5000", "꽝", "3000"));
        Results results = Results.of(resultsList);

        Positions positions = Positions.of(Arrays.asList(2, 1, 3, 0));

        assertThat(results.getFinalResults(positions))
                .isEqualTo(Results.of(Arrays.asList("꽝", "5000", "3000", "꽝")));
    }
}
