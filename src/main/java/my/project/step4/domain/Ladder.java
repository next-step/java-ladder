package my.project.step4.domain;

import my.project.common.domain.Users;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<LadderLine> ladder;

    public Ladder(Users users, int height) {
        this.ladder = new ArrayList<>();
        int countOfPerson = users.getUsers().size();
        for (int lineIndex = 0; lineIndex < height; lineIndex++) {
            ladder.add(LadderLine.init(countOfPerson));
        }
    }

    public List<LadderLine> getLadder() {
        return ladder;
    }
}
