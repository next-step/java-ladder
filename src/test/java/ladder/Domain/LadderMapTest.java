package ladder.Domain;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderMapTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi,honux,crong,jk:4", "pobi,honux,crong:3", "pobi,honux:2"}, delimiter = ':')
    void createLadderMapTest(String input, String expected) {
        Users uesrs = Users.of(input);
        int height = 4;
        CrossRoadStrategy crossRoadStrategy = () -> true;

        LadderMap ladderMap = LadderMap.of(uesrs, height, crossRoadStrategy);

        ladderMap.toList().forEach(line -> {
            System.out.println(line.toList().toString());
            assertThat(line).isEqualTo(Line.of(Integer.parseInt(expected), crossRoadStrategy));
        });
    }
}
