package ladder.domain;

import ladder.domain.person.Person;
import org.junit.jupiter.api.Test;


public class ResultMapTest {

    @Test
    void create() {
        ResultMap resultMap = new ResultMap(new Person("pobi", 0), new Person("crong", 1));
    }
}
