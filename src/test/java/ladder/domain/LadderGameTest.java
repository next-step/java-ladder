package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {
    @Test
    void start() {
        //Given
        LadderSize ladderSize = new LadderSize(4, 5);
        Ladder ladder = new Ladder(ladderSize);

        //When
        LadderGame ladderGame = new LadderGame(ladder);

        //Then
        assertThat(ladderGame.getLadderResult().size()).isEqualTo(4);
    }

}