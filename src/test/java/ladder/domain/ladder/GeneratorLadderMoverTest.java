package ladder.domain.ladder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneratorLadderMoverTest {


    @ParameterizedTest
    @ValueSource(ints = {3, 5, 6, 7})
    public void creatLadder(int width) {
        //Given
        GeneratorLadderMover mover = new RandomGeneratorLadderMover();

        //When
        Line line = mover.generateLine(width);

        //Then
        assertThat(line).isNotNull();
        assertThat(line.sizeWidth()).isEqualTo(width);
    }

}
