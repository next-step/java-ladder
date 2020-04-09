package ladder.Domain;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ClimberTest {

    private Climber climber;

    @BeforeEach
    void setUp() {
        climber = Climber.init();
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,honux,crong,jk:4", "pobi,honux,crong:3", "pobi,honux:2"}, delimiter = ':')
    void createLadderMapTest(String input, String expected) {
        LadderMap ladderMap = climber.createLadder(input, 4);

        ladderMap.toList().forEach(line -> {
            assertThat(line).isEqualTo(Line.of(Integer.parseInt(expected), crossRoadStrategy));
        });
    }
}
