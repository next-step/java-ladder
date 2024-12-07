package nextstep.laddergame.service;

import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.Line;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

class RandomLadderFactoryTest {
    @DisplayName("Ladders 객체를 생성한다.")
    @Test
    void createLadder() {
        List<Boolean> givenLine = List.of(true, false, true);
        LadderFactory laddersFactory = new RandomLadderFactory();

        Ladder actual = laddersFactory.createLadder(3, 3, lineCount -> new Line(givenLine));

        assertThat(actual).extracting("lines", as(InstanceOfAssertFactories.LIST))
                .contains(new Line(List.of(true, false, false)),
                        new Line(List.of(true, false, false)),
                        new Line(List.of(true, false, false)));
    }
}
