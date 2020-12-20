package nextstep.ladder;

import nextstep.ladder.model.People;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PeopleTest {

    @Test
    @DisplayName("사람 생성 테스트")
    public void initTest(){
        People people = new People("a,b,c");
        assertThat(people.getPeople().length).isEqualTo(3);
    }
}
