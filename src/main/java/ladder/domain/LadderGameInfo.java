package ladder.domain;

import java.util.List;
import java.util.Map;

public class LadderGameInfo {

    private final LadderGameSetting ladderGameSetting;
    private final int height;

    public LadderGameInfo(LadderGameSetting ladderGameSetting, int height) {
        this.ladderGameSetting = ladderGameSetting;
        this.height = height;
    }

    public List<Person> getPersons() {
        return ladderGameSetting.getPersons();
    }

    public List<String> getPrizes() {
        return ladderGameSetting.getPrizes();
    }

    public int getHeight() {
        return height;
    }

    public Map<String, String> result(Ladder ladder) {
        return ladderGameSetting.findPrize(ladder);
    }
}
