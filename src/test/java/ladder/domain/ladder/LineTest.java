package ladder.domain.ladder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
    @ValueSource(ints = {0, 1, 2, 3})
    public void isAvailableMoveTest(int index) {
        //Given
        List<Boolean> expectedPoints = Arrays.asList(true, false, false, true);
        Line line = new Line(expectedPoints);

        //When
        boolean expected = line.isAvailableMove(index);

        //Then
        assertThat(expected).isEqualTo(expectedPoints.get(index));
    }
}