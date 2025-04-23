package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NamesTest {

    @Test
    @DisplayName("참여자 이름이 최대 글자수를 초과하면 에러가 발생한다.")
    void exceedNameLengthLimit() {
        assertThatThrownBy(() -> new Names("sunny", "universe"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참여자 이름이 들어간 리스트가 반환된다.")
    void getAllNames() {
        assertThat(new Names("red", "blue", "green").getAll()).contains("red", "blue", "green");
    }

    @Test
    @DisplayName("참여자 순번을 입력하면 참여자 이름을 반환한다.")
    void getNameByIndex() {
        assertThat(new Names("red", "blue").get(1)).isEqualTo("blue");
    }
}
