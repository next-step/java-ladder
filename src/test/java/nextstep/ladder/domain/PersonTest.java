package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @DisplayName("이름을 입력하면 참여자를 생성한다.")
    @Test
    void createPerson() {
        Person person = new Person("안녕하세요");
        System.out.println(person);
    }
}
