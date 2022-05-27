package ladder.domain;

import ladder.constant.Direction;
import ladder.constant.Point;
import ladder.exception.InvalidNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    @DisplayName("글자수가 5자를 초과하면 InvalidNameException 반환한다.")
    void invalidName() {
        assertThatThrownBy(() -> new Name("qwerty")).isInstanceOf(InvalidNameException.class)
                .hasMessage("이름은 5 글자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("이름이 Null 이거나 공란일 경우 InvalidNameException 반환한다.")
    void invalidNullOrBlank() {
        assertThatThrownBy(() -> new Name(" ")).isInstanceOf(InvalidNameException.class)
                .hasMessage("이름은 공란이거나 Null 일 수 없습니다.");

        assertThatThrownBy(() -> new Name(null)).isInstanceOf(InvalidNameException.class)
                .hasMessage("이름은 공란이거나 Null 일 수 없습니다.");
    }

    @Test
    @DisplayName("한글의 크기는 한 글자당 2 이다.")
    void sizeKorean() {
        assertThat(new Name("꽝").size()).isEqualTo(2);
        assertThat(new Name("꽝꽝").size()).isEqualTo(4);
        assertThat(new Name("꽝꽝꽝").size()).isEqualTo(6);
    }

    @Test
    @DisplayName("영어 혹은 숫자의 크기는 한 글자당 1이다")
    void sizeEnglishOrNumber() {
        assertThat(new Name("10").size()).isEqualTo(2);
        assertThat(new Name("abc").size()).isEqualTo(3);
    }

    @Test
    @DisplayName("한글과 영어, 숫자 혼합일 경우 사이즈 검사")
    void sizeCombination() {
        assertThat(new Name("10꽝").size()).isEqualTo(4);
        assertThat(new Name("abc님").size()).isEqualTo(5);
    }
}