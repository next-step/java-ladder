package nextstep.ladder.domain.person;

import nextstep.ladder.domain.person.People;
import org.junit.jupiter.api.Test;

public class PeopleTest {


    @Test
    void name() {
        People.of("포비,크롱,짱구,철수");
    }
}
