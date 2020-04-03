package ladder.domain;

import ladder.exception.LadderException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WayTest {

    @DisplayName("생성자 정상 테스트")
    @Test
    public void constructor_success() throws Exception {
        //then
        assertThat(new Way(true, false));
        assertThat(new Way(false, true));
        assertThat(new Way(false, false));
    }

    @DisplayName("양방향 이동은 불가능 하다")
    @Test
    public void validate_fail() throws Exception {
        //then
        assertThatThrownBy(
                () -> new Way(true, true)
        ).isInstanceOf(LadderException.class);
    }
}
