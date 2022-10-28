package ladder.domain.result;

import ladder.domain.person.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class ResultMapTest {

    @Test
    void setPersonResult() {
        Person pobi = new Person("pobi", 0);
        Person crong = new Person("crong", 1);
        ResultMap resultMap = new ResultMap(pobi, crong);
        resultMap.setPersonResult(pobi, "꽝");

        Assertions.assertThat(resultMap.result(pobi)).isEqualTo(new Result("꽝"));
    }
}
