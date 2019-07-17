package ladder.domain;

import java.util.List;

public class GameReward {
    private final String nameReward;
    private String nameOfWinner;
    private final int index;

    GameReward(String name, int index) {
        this.nameReward = name;
        this.index = index;
    }

    void matchReward(List<SingleUser> userGroup) {
        for (SingleUser user : userGroup) {
            if (user.getPosition().matchIndex(this.index)) {
                this.nameOfWinner = user.getName();
                break;
            }
        }
    }

    public String getNameOfWinner() {
        return nameOfWinner;
    }

    public String getNameReward() {
        return nameReward;
    }

    @Override
    public String toString() {
        return getNameOfWinner() + ": " + getNameReward();
    }
}
