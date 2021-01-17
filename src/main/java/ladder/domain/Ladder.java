package ladder.domain;

import ladder.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private List<Name> names;
    private int height ;
    private List<Line> lines;
    public Ladder(){}

    public Ladder(String names, int height) {
        this.names = participateNames(names);
        this.height = height;
    }

    protected List<Name> participateNames(String names) {
        String[] strings = StringUtil.splitNames(names);
        List<Name> collect = Arrays.stream(strings)
                .map(Name::new)
                .collect(Collectors.toList());
        return collect;
    }

    public List<Line> generateLadderLine() {
        int countOfName = this.names.size();
        int countOfLine = this.height;
        List<Line> generatedLine = Stream.generate(() -> new Line(countOfName))
                .limit(countOfLine).collect(Collectors.toList());
        this.lines = generatedLine;
        return generatedLine;
    }
    public List<Line> resultLadder(){
        return new ArrayList<>(this.lines);
    }

    public List<Name> participateNames() {
        return new ArrayList<>(this.names);
    }
}
