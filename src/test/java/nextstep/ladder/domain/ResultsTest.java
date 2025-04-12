package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {
    @Test
    @DisplayName("Results 생성 후 getResult 통해 결과를 제대로 가져오는지 확인")
    void getResult_test() {
        Name name1 = new Name("p1");
        Name name2 = new Name("p2");
        Name name3 = new Name("p3");
        Name result1 = new Name("1000");
        Name result2 = new Name("2000");
        Name result3 = new Name("3000");
        Participants participants = new Participants(List.of(new Participant(name1, 2), new Participant(name2, 1), new Participant(name3, 0)));
        List<Name> results = List.of(result1, result2, result3);
        Results result = participants.getMatchResults(results);
        assertThat(result.getResult(name1)).isEqualTo("3000");
        assertThat(result.getResult(name2)).isEqualTo("2000");
        assertThat(result.getResult(name3)).isEqualTo("1000");
    }
}
