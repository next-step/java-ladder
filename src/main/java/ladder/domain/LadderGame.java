package ladder.domain;

import ladder.util.InputUtil;
import ladder.view.PrintResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private List<GamePerson> names;
    private List<Line> lines = new ArrayList<>();
    private int ladderHeight;

    public LadderGame(String namesValue) {
        this(namesValue,1);
    }

    public LadderGame(String namesValue, int ladderHeight) {
        this.ladderHeight = ladderHeight;
        names = Arrays.stream(StringSplit.splitWithDelimiter(namesValue))
                .map(GamePerson::new)
                .collect(Collectors.toList());
    }

    public void game() {
        makeLines();
        PrintResult.printNames(names);
        PrintResult.makeLadder(lines);
    }

    public void makeLines() {
        for(int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(names.size()));
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public List getNames() {
        return names;
    }
}
