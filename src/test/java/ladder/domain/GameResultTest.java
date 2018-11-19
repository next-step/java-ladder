package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.player.People;
import ladder.domain.player.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        Ladder ladder = new Ladder(5);
        LadderResult ladderResult = new LadderResult("꽝,5000,꽝,3000", new People("a,b,c,d"));
        List<Result> results = new ArrayList<>();
        results.add(ladderResult.getResultForPerson(new Person("a"), ladder));
        results.add(ladderResult.getResultForPerson(new Person("b"), ladder));
        results.add(ladderResult.getResultForPerson(new Person("c"), ladder));
        results.add(ladderResult.getResultForPerson(new Person("d"), ladder));
        assertThat(results.size()).isEqualTo(4);
    }
}