package ladder;

import ladder.domain.*;
import java.util.List;

public class LadderGame {

    public static LadderResult draw(LadderGameInfo ladderGameInfo) {
        List<Person> persons = ladderGameInfo.getPersons();
        Height height = Height.of(ladderGameInfo.getHeight());
        Ladder ladder = Ladder.create(height, persons.size());

        return new LadderResult(ladderGameInfo, ladder);
    }

    public static ResultPrize play(LadderResult ladderGameResult) {
        return new ResultPrize(ladderGameResult.findResult());
    }
}
