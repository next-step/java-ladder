package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("참가하는 사람들과 사다리를 만들 수 있다")
    @Test
    void ladder() {
        // given
        LadderHeight heightOfLadder = LadderHeight.of(5);

        List<Person> gamers = new ArrayList<>();
        gamers.add(Person.of("Pobi1"));
        gamers.add(Person.of("Pobi2"));
        gamers.add(Person.of("Pobi3"));

        // when
        Ladder ladder = Ladder.of(gamers, heightOfLadder);

        // then
        assertThat(ladder.ladderHeight().size()).isEqualTo(heightOfLadder.height());
        assertThat(ladder.persons().size()).isEqualTo(3);
    }


}
