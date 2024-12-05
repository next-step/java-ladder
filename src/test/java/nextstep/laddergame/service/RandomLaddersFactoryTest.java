package nextstep.laddergame.service;

import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.Ladders;
import nextstep.laddergame.domain.Lines;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLaddersFactoryTest {
    @DisplayName("Ladders 객체를 생성한다.")
    @Test
    void createLadders() {
        List<Boolean> givenLines = List.of(true, false, true, false, true);
        LaddersFactory laddersFactory = new RandomLaddersFactory();

        Ladders ladders = laddersFactory.createLadders(3, 5, (beforeLadder, maxHeight) -> new Lines(givenLines));

        assertThat(ladders).isEqualTo(new Ladders(List.of(
                new Ladder(0, new Lines(givenLines)),
                new Ladder(1, new Lines(givenLines)),
                new Ladder(2, new Lines(List.of(false, false, false, false, false))
                ))));
    }
}
