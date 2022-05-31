package nextstep.ladder.domain.runresult;

import nextstep.ladder.domain.member.MembersTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RunResultsTest {
    public static RunResults create(String string) {
        return new RunResults(string);
    }

    @Test
    void findRunResult() {
        RunResults results = create("꽝,3000,꽝,5000");

        RunResult pobiRunResult = results.findRunResult("pobi", MembersTest.members);

        assertThat(pobiRunResult).isEqualTo(new RunResult("꽝"));
    }
}
