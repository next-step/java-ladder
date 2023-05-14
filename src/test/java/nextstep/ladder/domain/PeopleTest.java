package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PeopleTest {

    @Test
    void 첫번째_사람_이름_길이_구하기() {
        //given
        People people = new People(new String[]{"pobi", "honux"});

        //when
        int firstNameLength = people.firstNameLength();

        //then
        assertThat(firstNameLength).isEqualTo(4);
    }

    @Test
    void 입력된_사람_없을시_예외() {
        assertThatThrownBy(() -> new People(Collections.emptyList()))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("사람 이름이 입력되지 않았습니다.");
    }
}
