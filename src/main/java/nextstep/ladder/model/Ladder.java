package nextstep.ladder.model;

import java.util.Arrays;
import java.util.List;

public class Ladder {
    private int height;
    private Lines lines;

    public Ladder(int countOfPerson, int height){
        this.height = height;
        lines = new Lines(countOfPerson, this.height);

    }
    public List<Line> getLines(){
        return lines.getLines();
    }



}
