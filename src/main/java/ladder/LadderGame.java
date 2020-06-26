package ladder;

import ladder.domain.*;
import java.util.List;

public class LadderGame {

    public static LadderResult draw(LadderGameInfo ladderGameInfo) {
        Persons persons = ladderGameInfo.getPersons();
        Height height = Height.of(ladderGameInfo.getHeight());
        Ladder ladder = Ladder.create(height, persons.count());

        return new LadderResult(ladderGameInfo, ladder);
    }

    public static ResultPrize play(LadderResult drawnladder) {
        return ResultPrize.of(drawnladder.findResult());
    }
}
