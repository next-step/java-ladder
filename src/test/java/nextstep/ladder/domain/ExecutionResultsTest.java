package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExecutionResultsTest {

    @Test
    @DisplayName("empty이면 예외('' => IllegalArgumentException)")
    void null_or_empty() {
        assertThatThrownBy(() -> {
            new ExecutionResults("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("실행결과값들은 ','를 구분자로 구분('꽝,5000,꽝,3000' => 꽝,5000,꽝,3000)")
    void split() {
        ExecutionResults executionResults = new ExecutionResults("꽝,5000,꽝,3000");
        assertThat(executionResults).isEqualTo(new ExecutionResults(
                List.of(new Destination("꽝"),
                        new Destination("5000"),
                        new Destination("꽝"),
                        new Destination("3000"))));
    }

    @Test
    @DisplayName("실행결과의 개수는 참가자 수랑 다르면 예외(3,4 => IllegalArgumentException)")
    void check_size() {
        Participants participants = new Participants(List.of(new Participant("a"), new Participant("b"), new Participant("c")));
        ExecutionResults executionResults = new ExecutionResults(List.of(new Destination("꽝"), new Destination("5000"), new Destination("꽝"), new Destination("3000")));
        assertThatThrownBy(() -> {
            executionResults.validateSize(participants);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
