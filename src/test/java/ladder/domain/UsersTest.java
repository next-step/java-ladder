package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UsersTest {
    @Test
    @DisplayName("입력받은 사용자 이름을 쉼표로 구분하여 배열로 반환한다.")
    void splitNames() {
        // given
        String names = "pobi,honux,crong,jk";

        // when
        Users actual = new Users(names);

        // then
        assertThat(actual).isEqualTo(new Users(List.of("pobi", "honux", "crong", "jk")));
        assertThat(actual.getUserName(0)).isEqualTo("pobi");
        assertThat(actual.getUserName(1)).isEqualTo("honux");
        assertThat(actual.getUserName(2)).isEqualTo("crong");
        assertThat(actual.getUserName(3)).isEqualTo("jk");
    }

    @Test
    @DisplayName("입력받은 사용자 이름이 쉼표로 구분되지 않는 경우 예외를 발생시킨다.")
    void splitNamesException() {
        // given
        String names = "pobi,honux,crong;jk";

        // when
        assertThatThrownBy(() -> {
            new Users(names);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 ,로 구분되지 않았거나 글자 수를 초과하였습니다.");
    }
}