package nextstep.ladder;

import nextstep.ladder.model.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {


    @Test
    @DisplayName("객체 생성 테스트")
    public void initTest(){
        Person person = new Person("abc",0);

        assertThat(person.getName()).isEqualTo("abc");
        assertThat(person.getPosition()).isEqualTo(0);
    }
}
