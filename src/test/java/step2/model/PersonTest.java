package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.util.StringUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
- 참여할 사람들을 생성한다.
- 참여할 사람 이름을 입력받을 시 최소 2명이상이여야한다.
*/
public class PersonTest {

    @DisplayName("참여할 사람들을 생성한다.")
    @Test
    void createPersonTest() {
        Person person = Person.createPerson(StringUtil.divideNum("pobi,honux,crong,jk"));
        assertThat(person.getNames())
                .extracting("name")
                .containsExactly("pobi", "honux", "crong", "jk");
    }

    @DisplayName("참여할 사람 이름을 입력받을 시 최소 2명이상이여야한다.")
    @Test
    void createPersonMustOverTwoTest() {
        assertThatThrownBy(() -> Person.createPerson(StringUtil.divideNum("pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여 인원은 2명이상이여야 합니다.");
    }

}
