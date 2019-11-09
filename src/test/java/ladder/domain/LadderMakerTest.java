package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LadderMakerTest {

    @ParameterizedTest
    @CsvSource(value = {"3,3"}, delimiter = ',')
    void 생성(final String countOfLine, final String countOfRow) {
        LadderMaker ladderMaker = new LadderMaker(prevEnableToGenerate -> {
            if (prevEnableToGenerate) {
                return false;
            }

            return true;
        });
        Ladder ladder = ladderMaker.makeLadder(Integer.parseInt(countOfLine), Integer.parseInt(countOfRow));
    }
}
