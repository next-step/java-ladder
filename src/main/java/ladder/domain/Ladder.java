package ladder.domain;

import ladder.util.StringUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {

    private List<Name> names;
    private List<Line> lines;

    public Ladder(String names) {
        this.names = participateNames(names);
    }

    protected static List<Name> participateNames(String names) {
        String[] strings = StringUtil.splitNames(names);
        return Arrays.asList(strings).stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public List<Line> generateLadderLine(int ladderHeight) {
        int countOfName = this.names.size();
        List<Line> generatedLine = IntStream.iterate(0, i -> i++)
                .mapToObj((element) -> new Line(countOfName))
                .limit(ladderHeight).collect(Collectors.toList());
        this.lines = generatedLine;
        return generatedLine;
    }
    public List<Line> resultLadder(){
        return new ArrayList<>(this.lines);
    }

    public List<Name> participateNames() {
        return Collections.unmodifiableList(this.names);
    }
}
