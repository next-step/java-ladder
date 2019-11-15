package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LadderMakerTest {

    @ParameterizedTest
    @CsvSource(value = {"3,3"}, delimiter = ',')
    void 생성(final String countOfPlayer, final String countOfRow) {
        LadderMaker ladderMaker = new LadderMaker(() -> true);
        Ladder ladder = ladderMaker.makeLadder(Integer.parseInt(countOfPlayer), Integer.parseInt(countOfRow));
        System.out.println(ladder);
    }
}
