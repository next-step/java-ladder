package ladder.domain;

import ladder.exception.InvalidCountOfPersonException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PeopleTest {

    @Test
    @DisplayName("참가자 수는 2 이상이여야 한다.")
    void invalidCount() {
        assertThatThrownBy(() -> new People("tom"))
                .isInstanceOf(InvalidCountOfPersonException.class)
                .hasMessage("참가자의 수는 2 이상이여야 합니다.");
    }

    @Test
    @DisplayName("총 필요한 좌표 개수는 사람의 수보다 1 작다.")
    void totalPoint() {
        assertThat(new People("tom", "tommy", "paul").pointCount()).isEqualTo(2);
    }
}