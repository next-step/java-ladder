package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResult {

    private List<String> names = new ArrayList<>();
    private List<Line> ladder = new ArrayList<>();

    public LadderResult(Names names, Ladder ladder) {
        this.names = names.getNames().stream().map(Name::getName).collect(Collectors.toList());
        this.ladder = ladder.getLines();
    }

    public List<String> getNames() {
        return names;
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
