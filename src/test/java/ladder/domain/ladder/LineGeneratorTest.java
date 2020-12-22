package ladder.domain.ladder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LineGeneratorTest {


    @ParameterizedTest
    @ValueSource(ints = {3, 5, 6, 7})
    public void creatLadder(int width) {
        //Given
        LineGenerator mover = new RandomLineGenerator();

        //When
        Line line = mover.generateLine(width);

        //Then
        assertThat(line.sizeWidth()).isEqualTo(width);
    }
}
