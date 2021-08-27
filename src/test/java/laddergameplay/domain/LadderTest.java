package laddergameplay.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("Ladder 생성")
    void create() {
        // given
        int countOfPeople = 4;
        int heightOfLadder = 5;

        // when
        Ladder ladder = new Ladder(countOfPeople, heightOfLadder);

        // then
        assertThat(ladder.getLadder().size()).isEqualTo(heightOfLadder);
    }
}
