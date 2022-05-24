package nextstep.ladder.domain.person;

import nextstep.ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {

    @DisplayName("이름을 입력하면 참여자를 생성한다.")
    @Test
    void createPerson() {
        Person person = new Person("안녕하세요");
        System.out.println(person);
    }

    @DisplayName("기존 참가자를 바탕으로 다음 참가자를 생성한다.")
    @Test
    void createNextPersonTest() {
        Person pobi = Person.first("포비");
        assertThat(pobi.next("크롱"))
                .isEqualTo(new Person(Position.from(1), "크롱"));
    }

    @DisplayName("참가자의 위치를 반환한다.")
    @Test
    void positionTest() {
        Person pobi = new Person(Position.from(5), "포비");
        assertThat(pobi.position())
                .isEqualTo(Position.from(5));
    }

    @DisplayName("참가자와 이름이 같은지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"포비:true", "크롱:false"}, delimiter = ':')
    void equalNameTest(String name, boolean match) {
        Person pobi = new Person(Position.from(5), "포비");
        assertThat(pobi.equalName(new Name(name))).isEqualTo(match);
    }
}
