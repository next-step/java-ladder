package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Height {
    private final int height;

    public Height(int height) {
        if(height <= 1){
            throw new IllegalArgumentException();
        }
        this.height = height;
    }

    public List<Line> generateLines(Participant participant){
        ArrayList<Line> lines = new ArrayList<>();
        for(int i =0; i < height; i++){
            lines.add(new Line(participant));
        }
        return lines;
    }
}
