package ladder.domain;

import java.util.List;

public class LadderGameResult {

    private final LadderGameInfo ladderGameInfo;
    private final Ladder ladder;

    public LadderGameResult(LadderGameInfo ladderGameInfo, Ladder ladder) {
        this.ladderGameInfo = ladderGameInfo;
        this.ladder = ladder;
    }

    public List<Person> getPersons(){
        return ladderGameInfo.getPersons();
    }

    public List<String> getPrizes(){
        return ladderGameInfo.getPrizes();
    }

    public Ladder getLadder() {
        return ladder;
    }
}
