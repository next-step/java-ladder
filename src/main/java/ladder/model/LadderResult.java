package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResult {

    private List<String> names = new ArrayList<>();
    private List<Line> ladder = new ArrayList<>();

    public LadderResult(Users users, Ladder ladder) {
        this.names = users.getUsers().stream().map(User::getName).collect(Collectors.toList());
        this.ladder = ladder.getLines();
    }

    public List<String> getNames() {
        return names;
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
