package ladder.domain;

import java.util.List;

public class GameReward {
    private String nameReward;
    private String nameOfWinner;
    private int row = 0;
    private int col;

    GameReward(String name, int row, int col) {
        this.nameReward = name;
        this.row = row;
        this.col = col;
    }

    public void matchReward(List<GameUser> userGroup) {
        userGroup.stream().forEach(user -> {
            if (user.getPosition().matchRow(this.row) && user.getPosition().matchCol(this.col)) {
                this.nameOfWinner = user.getName();
            }
        });
    }

    public String getNameOfWinner() {
        return nameOfWinner;
    }

    public String getNameReward() {
        return nameReward;
    }

}
