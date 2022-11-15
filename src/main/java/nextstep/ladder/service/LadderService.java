package nextstep.ladder.service;

import nextstep.ladder.domain.*;

import java.util.ArrayList;
import java.util.List;

public class LadderService {

    private final Ladder ladder;

    public LadderService(String inputNames, int height) {
        Users users = new Users(StringUserNamesToUsersGenerator.toUsers(inputNames));
        Lines lines = new Lines(createLines(height, users.getUserSize()));
        this.ladder = new Ladder(users, lines);
    }

    private List<Line> createLines(int height, int countOfPerson) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson, new RandomLineGenerator()));
        }
        return lines;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
