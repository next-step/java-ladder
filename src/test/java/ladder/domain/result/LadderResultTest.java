package ladder.domain.result;

import ladder.domain.players.Person;
import ladder.domain.rewards.Item;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LadderResultTest {

    @Test
    public void 사다리_결과_확인() {
        LadderResult ladderResult = new LadderResult();
        ladderResult.addResult(new Person("nj"), new Item("꽝"));

        assertThat(ladderResult.getItemByPersonName("nj").value()).isEqualTo(new Item("꽝").value());
    }
}
