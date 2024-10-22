package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
- 참여할 사람들을 생성한다.
- 참여할 사람 이름을 입력받을 시 최소 2명이상이여야한다.
- 이름을 입력시 몇번째 사다리인지 반환한다.
- 이름을 입력시 존재하지 않는 사람이면 예외를 발생시킨다.
*/
public class PersonTest {

    @DisplayName("참여할 사람들을 생성한다.")
    @Test
    void createPersonTest() {
        Person person = Person.createPerson("pobi,honux,crong,jk");
        assertThat(person.getNames())
                .extracting("name")
                .containsExactly("pobi", "honux", "crong", "jk");
    }

    @DisplayName("참여할 사람 이름을 입력받을 시 최소 2명이상이여야한다.")
    @Test
    void createPersonMustOverTwoTest() {
        assertThatThrownBy(() -> Person.createPerson("pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여 인원은 2명이상이여야 합니다.");
    }

    @DisplayName("이름을 입력시 몇번째 사다리인지 반환한다.")
    @Test
    void getPersonIndexTest() {
        Person person = Person.createPerson("pobi,honux,crong,jk");

        assertThat(person.getPersonIndex("honux")).isEqualTo(new int[]{1});
    }

    @DisplayName("이름을 입력시 존재하지 않는 사람이면 예외를 발생시킨다.")
    @Test
    void getPersonIndexNotExistThrowExceptionTest() {
        Person person = Person.createPerson("pobi,honux,crong,jk");

        assertThatThrownBy(() -> person.getPersonIndex("test"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 일치하는 사람이 없습니다.");
    }

}
