package ladder.domain.ladder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderFactoryTest {

    @ParameterizedTest
    @CsvSource(value = {"5:4", "6:5", "7:6"}, delimiter = ':')
    public void createLadderTest(int width, int height) {
        //Given & When
        Ladder ladder = LadderFactory.makeLadder(new LadderStructure(width, height), new RandomLineGenerator());

        //Then
        assertThat(ladder.sizeWidth()).isEqualTo(width);
        assertThat(ladder.sizeHeight()).isEqualTo(height);
    }
}
