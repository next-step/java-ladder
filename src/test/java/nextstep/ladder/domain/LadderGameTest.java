package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderGameTest {

    @Test
    void 전체_검증() {

        LadderGame ladderGame = new LadderGame(new Persons("jigi,abc"), 1);

        assertAll(
                ()->assertThat(ladderGame.getHeights().getHeight().size()).isEqualTo(1),
                ()->assertThat(ladderGame.getPersons().getMaxLength()).isEqualTo(4),
                ()->assertThat(ladderGame.getPersons().getPersons().size()).isEqualTo(2)
        );


    }
}
