package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderMappingTest {

    LadderMapping ladderMapping;

    @BeforeEach
    void setUp() {
        ladderMapping = new LadderMapping(new Participants("a,b,c"), new ExecutionResults("꽝,2000,3000"));
    }

    @Test
    @DisplayName("결과 조회자가 null 일 경우에 예외(null => IllegalArgumentException)")
    void null_or_empty() {
        assertThatThrownBy(() -> {
            ladderMapping.showResult(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("결과 조회자가 참가자가 아니라면 예외(a,b,c,d | e => IllegalArgumentException)")
    void not_participants() {
        assertThatThrownBy(() -> {
            ladderMapping.showResult(new Participant("e"));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("결과 조회 대상자라면 해당 조회자의 결과만 조회('a' => a:꽝)")
    void show_all() {
        assertThat(ladderMapping.showResult(new Participant("a"))).isEqualTo(new ExecutionResult("꽝"));
    }
}
