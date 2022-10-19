package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PeopleTest {
    @Test
    @DisplayName("이름에 중복된 값이 들어오면 IllegalArgumentException")
    void when_duplicate() {
        //given
        String[] names = "name, name, abc".split(",");
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new People(names));
    }

    @Test
    @DisplayName("이릅에 중복된 값이 잆으면 정상")
    void when_not_duplicate() {
        //given
        String[] names = "name, kkk, abc".split(",");
        //then
        assertThatNoException()
                .isThrownBy(() -> new People(names));
    }

    @Test
    @DisplayName("출력하고 싶은 이름이 있으면 true")
    void validate_person_name_in_people_true() {
        //given
        String[] names = "name, kkk, abc".split(",");
        People people = new People(names);
        //when
        PersonName name = new PersonName("name");
        //then
        assertThat(people.contains(name)).isTrue();

    }

    @Test
    @DisplayName("출력하고 싶은 이름이 없으면 false")
    void validate_person_name_in_people_false() {
        //given
        String[] names = "name, kkk, abc".split(",");
        People people = new People(names);
        //when
        PersonName name = new PersonName("ccc");
        //then
        assertThat(people.contains(name)).isFalse();

    }

    @Test
    @DisplayName("이름으로 인덱스 반환")
    void get_index_by_name() {
        //given
        String[] names = "name, kkk, abc".split(",");
        People people = new People(names);
        //when
        PersonName name = new PersonName("abc");
        //then
        assertThat(people.getIndex(name)).isEqualTo(2);
    }


}