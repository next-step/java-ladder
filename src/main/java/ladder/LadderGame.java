package ladder;

import ladder.domain.*;

public class LadderGame {

    public static LadderGameResult draw(LadderSetting ladderSetting) {
        Persons persons = Persons.of(ladderSetting.getPersons());
        Prizes prizes = Prizes.of(ladderSetting.getResults());
        Height height = Height.of(ladderSetting.getHeight());
        Ladder ladder = Ladder.create(height, persons.count());

        return new LadderGameResult(LadderGameInfo.of(persons, prizes), ladder);
    }
}
