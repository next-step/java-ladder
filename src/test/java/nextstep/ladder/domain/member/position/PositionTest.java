package nextstep.ladder.domain.member.position;

import nextstep.ladder.domain.runresult.RunResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    private Position position;

    @BeforeEach
    void setUp() {
        this.position = new Position(0, 0);
    }

    @Test
    void getMatchX() {
        List<RunResult> runResults = List.of(
                new RunResult("꽝"),
                new RunResult("3000"),
                new RunResult("꽝"),
                new RunResult("5000")
        );

        RunResult matchX = position.getMatchX(runResults);

        assertThat(matchX).isEqualTo(new RunResult("꽝"));
    }
}
