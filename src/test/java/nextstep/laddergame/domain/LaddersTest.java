package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LaddersTest {

    @DisplayName("사다리 Ladder 객체의 일급 컬렉션 클래스를 생성한다.")
    @Test
    void create() {
        List<Boolean> givenLines = List.of(true, false, true, false, true);

        Ladders ladders = Ladders.create(3, 5, (beforeLadder, maxHeight) -> new Lines(givenLines));

        assertThat(ladders).isEqualTo(new Ladders(List.of(
                new Ladder(0, new Lines(givenLines)),
                new Ladder(1, new Lines(givenLines)),
                new Ladder(2, new Lines(List.of(false, false, false, false, false))
                ))));
    }
}
