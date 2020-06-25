package ladder.domain;

import java.util.List;
import java.util.Map;

public class LadderResult {

    private final LadderGameInfo ladderGameInfo;
    private final Ladder ladder;

    public LadderResult(LadderGameInfo ladderGameInfo, Ladder ladder) {
        this.ladderGameInfo = ladderGameInfo;
        this.ladder = ladder;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<Person> getPersons(){
        return ladderGameInfo.getPersons();
    }

    public List<String> getPrizes(){
        return ladderGameInfo.getPrizes();
    }

    public Map<String, String> findResult(){
        return ladderGameInfo.result(ladder);
    }
}
