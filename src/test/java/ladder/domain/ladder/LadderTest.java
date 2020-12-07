package ladder.domain.ladder;

import ladder.exception.InsufficientLadderHeightException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @ParameterizedTest
    @CsvSource(value = {"2:5", "3:6"}, delimiter = ':')
    public void createInstanceTest(int height, int width) {
        //Given
        Ladder ladder = new Ladder(Arrays.asList(new Line(Arrays.asList())));

        //Then
        assertThat(ladder).isNotNull();
    }

    @DisplayName("높이가 2 미만일 경우 예외처리 테스트")
    @Test
    public void insufficientLadderHeightTest() {
        assertThatThrownBy(() ->
                new Ladder(Arrays.asList(new Line(Arrays.asList(true, false))))
        ).isInstanceOf(InsufficientLadderHeightException.class);
    }

    @ParameterizedTest
    @MethodSource("createLines")
    public void findByIndexTest(List<Line> lines) {
        //Given
        int index = 0;
        Ladder ladder = new Ladder(lines);

        //When
        Line line = ladder.findByIndex(index);

        //Then
        assertThat(line).isEqualTo(lines.get(index));
    }

    private static Stream<Arguments> createLines(){
        return Stream.of(
                Arguments.of((Arrays.asList(new Line(Arrays.asList(true, false, false, true)),
                             new Line(Arrays.asList(true, false, false, true)))))
        );
    }
}
