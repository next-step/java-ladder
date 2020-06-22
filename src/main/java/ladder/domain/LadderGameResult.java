package ladder.domain;

import java.util.List;

public class LadderGameResult {

    private final LadderSetting ladderSetting;
    private final Ladder ladder;

    public LadderGameResult(LadderSetting ladderSetting, Ladder ladder) {
        this.ladderSetting = ladderSetting;
        this.ladder = ladder;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<Person> getPersons(){
        return ladderSetting.getPersons();
    }

    public List<String> getPrizes(){
        return ladderSetting.getPrizes();
    }
}
