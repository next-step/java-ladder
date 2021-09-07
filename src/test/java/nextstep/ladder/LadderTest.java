package nextstep.ladder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1","2,5"})
    void generateTest(int numberOfParticipants, int height) {
        Ladder ladder = LadderFactory.generate(height, numberOfParticipants);
        assertEquals(height, ladder.getHorizontalLines().size());
    }

}
