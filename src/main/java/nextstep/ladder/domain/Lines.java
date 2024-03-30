package nextstep.ladder.domain;

import java.util.List;

public class Lines {

    private List<Line> lines;

    public Lines(Height height, Participant participant) {
        this(height.generateLines(participant));
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public int getSize(){
        return lines.size();
    }
}
