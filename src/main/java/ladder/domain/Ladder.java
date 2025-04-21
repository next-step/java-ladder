package ladder.domain;

import ladder.service.PointGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();
    private final Users users;
    private final Results results;

    public Ladder(Users users, Results results, LadderHeight height, PointGenerator pointGenerator) {
        validate(users, results);
        this.users = users;
        this.results = results;
        int countOfPerson = users.count();
        for (int i = 0; i < height.getHeight(); i++) {
            Line line = new Line(countOfPerson, pointGenerator);
            this.lines.add(line);
        }
    }

    private void validate(Users users, Results results) {
        if (users.count() != results.count()) {
            throw new IllegalArgumentException("사용자 수와 결과 수가 일치하지 않습니다.");
        }
    }

    public Results getResults() {
        return results;
    }

    public Users getUsers() {
        return users;
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }

    public Result findResult(User targetUser) {
        int index = users.getIndex(targetUser);
        for (Line line : lines) {
            index = line.getNextIndex(index);
        }
        return results.getResult(index);
    }

    public Map<User, Result> findResultAll() {
        return users.getUsers().stream()
                .collect(Collectors.toMap(user -> user, this::findResult));
    }
}
