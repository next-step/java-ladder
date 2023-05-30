package ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> lines = new ArrayList<>();

    public Ladder(int height, int nameSize){
        for(int i=0; i<height; i++){
            lines.add(new Line(nameSize));
        }
    }

    public List<Line> getLines(){
        return lines;
    }

}
