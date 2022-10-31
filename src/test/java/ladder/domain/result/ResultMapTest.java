package ladder.domain.result;

import ladder.domain.ladder.ladderline.LadderLines;
import ladder.domain.person.Person;
import ladder.dto.LadderGameResultDto;
import ladder.testutil.LadderLineTestUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


public class ResultMapTest {

    @Test
    void setPersonResult() {
        Person pobi = new Person("pobi", 0, 0);
        Person crong = new Person("crong", 1, 0);
        ResultMap resultMap = new ResultMap(pobi, crong);
        resultMap.setPersonResult(pobi, new Result("꽝"));

        assertThat(resultMap.result(pobi)).isEqualTo(new Result("꽝"));
    }

    @Test
    void setResult() {
        Person pobi = new Person("pobi", 0, 0);
        Person crong = new Person("crong", 1, 0);
        ResultMap resultMap = new ResultMap(pobi, crong);
        resultMap.setResult(
                new LadderGameResultDto(
                        new Results("1", "2"),
                        new LadderLines(List.of(LadderLineTestUtil.continuousLadder()))
                )
        );

        assertAll(
                () -> assertThat(resultMap.result(pobi)).isEqualTo(new Result("2")),
                () -> assertThat(resultMap.result(crong)).isEqualTo(new Result("1"))
        );
    }
}
