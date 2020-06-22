package ladder.domain;

import java.util.List;

public class LadderSetting {

    private final LadderGameInfo ladderGameInfo;
    private final int height;

    public LadderSetting(LadderGameInfo ladderGameInfo, int height) {
        this.ladderGameInfo = ladderGameInfo;
        this.height = height;
    }

    public List<Person> getPersons() {
        return ladderGameInfo.getPersons();
    }

    public List<String> getPrizes() {
        return ladderGameInfo.getPrizes();
    }

    public int getHeight() {
        return height;
    }
}
