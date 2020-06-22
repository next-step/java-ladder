package ladder;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Prizes;
import ladder.domain.Persons;
import ladder.domain.LadderSetting;
import ladder.domain.LadderGameInfo;

public class LadderGame {

    public static LadderGameInfo draw(LadderSetting ladderSetting) {
        Persons persons = Persons.of(ladderSetting.getPersons());
        Prizes prizes = Prizes.of(ladderSetting.getResults(), persons.count());
        Height height = Height.of(ladderSetting.getHeight());
        Ladder ladder = Ladder.create(height, persons.count());

        return new LadderGameInfo(persons, ladder, prizes);
    }
}
