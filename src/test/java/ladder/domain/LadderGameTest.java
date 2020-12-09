package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.RandomLineGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @ParameterizedTest
    @CsvSource(value = {"3:5", "2:6", "5:3", "6:12"}, delimiter = ':')
    public void makeLadderTest(int width, int height) {
        //Given
        LadderGame game = new LadderGame(new RandomLineGenerator());

        //When
        Ladder ladder = game.makeLadder(width, height);

        //Then
        assertThat(ladder.sizeWidth()).isEqualTo(width);
        assertThat(ladder.sizeHeight()).isEqualTo(height);
    }
}
