package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.Name;
import ladder.exception.NameLengthException;

class NameTest {
    @DisplayName("참여할 사람의 이름 문자열이 주어지면 Name객체를 생성한다")
    @Test
    void nameTest() {
        assertThat(Name.from("chang")).isInstanceOf(Name.class);
    }

    @DisplayName("참여할 사람의 이름이 null이면 예외를 발생시킨다")
    @Test
    void nullTest() {
        assertThatThrownBy(() -> Name.from(null)).isInstanceOf(NullPointerException.class);
    }

    @DisplayName("참여할 사람의 이름이 1자를 미만이면 예외를 발생시킨다")
    @Test
    void nameLengthTest1() {
        assertThatThrownBy(() -> Name.from("")).isInstanceOf(NameLengthException.class);
    }

    @DisplayName("참여할 사람의 이름이 5자를 초과하면 예외를 발생시킨다")
    @Test
    void nameLengthTest2() {
        assertThatThrownBy(() -> Name.from("changsubkwak")).isInstanceOf(NameLengthException.class);
    }
}
