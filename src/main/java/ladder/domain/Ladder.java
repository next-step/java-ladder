package ladder.entity;

import ladder.util.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private List<Name> names;
    private int height ;
    private List<Line> lines;
    public Ladder(String names, int height) {
        this.names = participateNames(names);
        this.height = height;
    }

    protected List<Name> participateNames(String names){
        String[] strings = StringUtil.splitNames(names);
        List<Name> collect = Arrays.stream(strings)
                .map(Name::new)
                .collect(Collectors.toList());
        return collect;
    }
    protected void generateLadderLine(int height){

    }
}
