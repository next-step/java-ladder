package nextstep.ladder.domain;

import nextstep.ladder.GameUser;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> ladder = new ArrayList<>();

    public Ladder(List<Line> ladderBoard) {
        this.ladder = ladderBoard;
    }

    public Ladder(int column, int row) {
        for (int i = 0; i < column; i++) {
            ladder.add(new Line(row));
        }
    }

    public void play(GameUsers gameUsers) {
        for (Line line : ladder) {
            for (GameUser gameUser : gameUsers.getGameUsers()) {
                gameUser.move(line);
            }
        }
    }

    public List<Line> getLadder() {
        return ladder;
    }

}
