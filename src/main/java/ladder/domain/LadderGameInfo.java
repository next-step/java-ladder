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

    public Persons getPersons() {
        return ladderGameSetting.getPersons();
    }

    public Prizes getPrizes() {
        return ladderGameSetting.getPrizes();
    }

    public int getHeight() {
        return height;
    }

    public List<ResultPrize> result(Ladder ladder) {
        return ladder.findPrize(ladderGameSetting);
    }
}
