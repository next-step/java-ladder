package nextstep.ladder.domain.person;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PeopleTest {

    @DisplayName("입력받은 이름을 바탕으로 참여자들을 생성한다.")
    @Test
    void createPeopleTest() {
        People people = People.from("포비,크롱,짱구,철수");
        System.out.println(people);
    }

    @DisplayName("입력받은 이름을 바탕으로 참여자들을 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"포비", ""})
    void createPeopleTestFail(String names) {
        assertThatThrownBy(() -> People.from(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참가자의 이름을 입력하면 일치하는 참가자를 반환한다.")
    @Test
    void personTest() {
        People people = People.from("포비,크롱,짱구,철수");
        assertThat(people.person("포비"))
                .isEqualTo(new Person("포비"));
    }

    @DisplayName("참가인원수를 반환한다.")
    @Test
    void sizeTest() {
        People people = People.from("포비,크롱,짱구,철수");
        assertThat(people.size()).isEqualTo(4);
    }

    @DisplayName("참가자 리스트를 반환한다.")
    @Test
    void personListTest() {
        People people = People.from("포비,크롱,짱구,철수");
        assertThat(people.people())
                .containsExactly(new Person("포비"), new Person("크롱"), new Person("짱구"), new Person("철수"));
    }
}
