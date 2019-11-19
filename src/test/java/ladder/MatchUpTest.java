package ladder;

import ladder.domain.MatchUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchUpTest {

    private MatchUp matchUp;

    @BeforeEach
    void setUp() {
        matchUp = new MatchUp("a,b,c,d", "1,2,3,4");
    }

    @Test
    @DisplayName("사다리 타기 사람 수")
    void matchUpPeopleCountTest() {
        assertThat(matchUp.getPeopleCount()).isEqualTo(4);
    }

    @Test
    @DisplayName("사다리 타기 경품 수")
    void matchUpResultCountTest() {
        assertThat(matchUp.getResultCount()).isEqualTo(4);
    }
}
