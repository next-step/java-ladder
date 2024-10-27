package nextstep.ladder;

import nextstep.ladder.model.Gamer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GamerTest {

    @Test
    void 정상_이름_확인() {
        String name = "P1";
        Gamer gamer = new Gamer(name);
        assertEquals(name, gamer.getName());
    }

    @Test
    void 빈_문자열_시_IllgegalException이_발생() {
        assertThatThrownBy(() -> new Gamer(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 빈 문자열이 될 수 없습니다.");
    }

    @Test
    void 이름_길이_5자_초과시_IllegalArgumentException이_발생() {
        assertThatThrownBy(() -> new Gamer("Player123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하여야 합니다.");
    }
}
