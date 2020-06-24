package ladder.domain;

import java.util.List;

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

    public String getPrize(int prizeIndex) {
        return ladderGameSetting.prize(prizeIndex);
    }
}
