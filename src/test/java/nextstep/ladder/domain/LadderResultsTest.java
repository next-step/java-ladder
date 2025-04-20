package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultsTest {
    @Test
    @DisplayName("Results 생성 후 getResult 통해 결과를 제대로 가져오는지 확인")
    void getResult_test() {
        Name name1 = new Name("p1");
        Name name2 = new Name("p2");
        Name name3 = new Name("p3");
        Name result1 = new Name("1000");
        Name result2 = new Name("2000");
        Name result3 = new Name("3000");
        Map<Name, Name> results = Map.of(
                name1, result1,
                name2, result2,
                name3, result3
        );
        LadderResults ladderResults = new LadderResults(results);
        assertThat(ladderResults.resultOf(name1)).isEqualTo(result1);
        assertThat(ladderResults.resultOf(name2)).isEqualTo(result2);
        assertThat(ladderResults.resultOf(name3)).isEqualTo(result3);
    }
}
