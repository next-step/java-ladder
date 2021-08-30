package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.Names;
import ladder.exception.PersonCountException;

class NamesTest {
    @DisplayName("참여할 사람들의 이름 문자열이 주어지면 Name객체를 생성한다")
    @Test
    void nameTest() {
        assertThat(Names.from("chang,sub,kwak")).isInstanceOf(Names.class);
    }

    @DisplayName("참여할 사람들의 입력문자열이 null이면 예외를 발생시킨다")
    @Test
    void nullTest() {
        String names = null;
        assertThatThrownBy(() -> Names.from(names)).isInstanceOf(NullPointerException.class);
    }

    @DisplayName("참여할 사람들의 인원수가 2명 미만 예외를 발생시킨다")
    @Test
    void namesLengthTest() {
        assertThatThrownBy(() -> Names.from("chang")).isInstanceOf(PersonCountException.class);
    }
}
