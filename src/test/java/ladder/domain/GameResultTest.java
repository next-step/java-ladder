package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    @Test
    public void 결과_한사람() {
        Ladder ladder = new Ladder(5);
        LadderResult ladderResult = new LadderResult("꽝,5000,꽝,3000", new People("a,b,c,d"));
        Result result = ladderResult.getResultForPerson(new Person("a"), ladder);
        assertThat(result).isEqualTo(new Result("꽝"));
    }

    @Test
    public void 결과_All() {
    }
}