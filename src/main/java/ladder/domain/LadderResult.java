package ladder.domain;

import java.util.LinkedHashMap;
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
        Map<String, String> result = new LinkedHashMap<>();
        int personIndex = 0;
        for (Person person : getPersons()){
            int prizeIndex = ladder.getPrizeIndex(personIndex);
            result.put(person.getName(), ladderGameInfo.getPrize(prizeIndex));
            personIndex++;
        }
        return result;
    }
}
