package ladder.domain.ladder;

import ladder.domain.participant.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @Test
    public void createInstanceTest() {
        //Given & When
        List<Boolean> expectedPoints = Arrays.asList(true, false, false, true, false);
        Line line = new Line(expectedPoints);

        //Then
        assertThat(line.sizeWidth()).isEqualTo(expectedPoints.size());

    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:-1", "2:0", "3:1", "4:-1"}, delimiter = ':')
    public void giveDirectionTest(int index, int expected) {
        //Given
        List<Boolean> expectedPoints = Arrays.asList(true, false, false, true);
        Line line = new Line(expectedPoints);

        //When
        int result = line.giveDirection(Position.from(index));

        //Then
        assertThat(result).isEqualTo(expected);
    }
}