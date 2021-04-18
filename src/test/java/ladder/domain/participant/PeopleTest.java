package ladder.domain.participant;

import ladder.exception.ParticipantListNullPointerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PeopleTest {

    @DisplayName("People 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        String[] names = "pobi,honux,crong,jk".split(",");

        // when
        People people = People.of(names);

        // then
        assertThat(people).isNotNull();
    }

    @DisplayName("People 인스턴스 null 입력시 예외처리 테스트")
    @Test
    void 검증() {
        // given
        List<Person> personList = null;

        // when and then
        assertThatThrownBy(() -> People.of(personList))
                .isInstanceOf(ParticipantListNullPointerException.class)
                .hasMessage("List<Participant>가 null 입니다.");

    }

    @DisplayName("People 인스턴스가 소유한 사람들의 숫자 반환 테스트")
    @Test
    void 반환() {
        // given
        String[] names = "pobi,honux,crong,jk".split(",");

        // when
        People people = People.of(names);
        int actual = people.countOfPerson();

        // when
        assertThat(actual).isEqualTo(4);
    }
}