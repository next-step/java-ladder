package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RungTest {

    public static final Rung TRUE = new Rung(true);
    public static final Rung FALSE = new Rung(false);

    @DisplayName("Point(점)은 boolean값을 갖는다")
    @Test
    void haveBoolean() {
        assertThat(TRUE).isEqualTo(new Rung(true));
        assertThat(FALSE).isEqualTo(new Rung(false));
    }

    @DisplayName("이전(i - 1) 점이 존재하는지 검증한다")
    @Test
    void hasPointAtPrevious() {
        assertThat(TRUE.isExist()).isTrue();
        assertThat(FALSE.isExist()).isFalse();
    }
}
