package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("참가하는 사람들과 사다리를 만들 수 있다")
    @Test
    void ladder() {
        // given
        LadderHeight heightOfLadder = LadderHeight.of(5);

        Persons persons = PersonsFactory.personsFixture();

        // when
        Ladder ladder = Ladder.of(persons, heightOfLadder);

        // then
        assertThat(ladder.ladderHeight().size()).isEqualTo(heightOfLadder.height());
        assertThat(ladder.persons().size()).isEqualTo(3);
    }


}
