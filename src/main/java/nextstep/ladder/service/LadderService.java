package nextstep.ladder.service;

import nextstep.ladder.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderService {

    private static final String REGEX = ",";

    private final Ladder ladder;

    public LadderService(String inputNames, int height) {
        Users users = new Users(createUsers(inputNames));
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

    private List<User> createUsers(String inputNames) {
        return splitCommaName(inputNames).stream()
                .map(User::new)
                .collect(Collectors.toList());
    }

    private List<String> splitCommaName(String inputNames) {
        return List.of(inputNames.split(REGEX));
    }

    public Ladder getLadder() {
        return ladder;
    }
}
