package ladder;

import ladder.domain.*;

import java.util.List;

public class LadderGame {

    public static LadderGameResult draw(LadderSetting ladderSetting) {
        List<Person> persons = ladderSetting.getPersons();
        Height height = Height.of(ladderSetting.getHeight());
        Ladder ladder = Ladder.create(height, persons.size());

        return new LadderGameResult(ladderSetting, ladder);
    }
}
