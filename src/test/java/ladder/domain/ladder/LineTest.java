package ladder.domain.ladder;

import ladder.domain.support.LineBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest extends LineBuilder {

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7, 8})
    public void createInstanceTest(int width) {
        //Given & When
        Line line = createRandomLineBuild(width);

        //Then
        assertThat(line.sizeWidth()).isEqualTo(width);

    }

    @Test
    public void giveDirectionTest() {
        //Given
        Line line = createRandomLineBuild(5);

        //When
        int first = line.giveDirection(0);
        int second = line.giveDirection(1);
        int third = line.giveDirection(2);
        int fourth = line.giveDirection(3);
        int fifth = line.giveDirection(4);

        //Then
        assertThat("");

    }
}