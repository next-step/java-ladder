package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Height implements LineFactory{
    private final int height;

    public Height(int height) {
        if(height <= 1){
            throw new IllegalArgumentException();
        }
        this.height = height;
    }

    public List<Line> generateLines(PointFactory pointFactory){
        ArrayList<Line> lines = new ArrayList<>();
        for(int i =0; i < height; i++){
            lines.add(new Line(pointFactory));
        }
        return lines;
    }
}
