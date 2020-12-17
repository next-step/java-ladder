package ladder.domain.ladder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderStructureTest {

    @ParameterizedTest
    @CsvSource(value = {"5:4", "6:5", "3:5"}, delimiter = ':')
    public void createInstanceTest(int width, int height) {
        //Given & When
        LadderStructure ladderStructure = new LadderStructure(width, height);

        //Then
        assertThat(ladderStructure).isEqualTo(new LadderStructure(width, height));
    }
}
