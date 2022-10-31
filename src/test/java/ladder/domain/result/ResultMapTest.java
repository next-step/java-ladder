package ladder.domain.result;

import ladder.domain.Rewards;
import ladder.domain.ladder.ladderline.LadderLines;
import ladder.domain.person.Person;
import ladder.dto.LadderGameResultDto;
import ladder.testutil.LadderLineTestUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class ResultMapTest {

    @Test
    void result() {
        Person pobi = new Person("pobi", 0, 0);
        Person crong = new Person("crong", 1, 0);
        List<Person> personList = List.of(pobi, crong);

        Rewards rewards = new Rewards("1000", "꽝");
        LadderLines ladderLines = new LadderLines(List.of(LadderLineTestUtil.continuousLadder()));

        ResultMap resultMap = new ResultMap(new LadderGameResultDto(rewards, ladderLines), personList);

        assertThat(resultMap.result(pobi).text()).isEqualTo("꽝");
        assertThat(resultMap.result(crong).text()).isEqualTo("1000");
    }
}
