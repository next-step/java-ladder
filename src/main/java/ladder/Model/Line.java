package ladder.Model;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points = new ArrayList <>();
    private boolean beforeLine = false;

    public Line(int countOfPerson) {
        for (int i = 1; i < countOfPerson; i++) {
            this.points.add(createLine());
        }
    }

    public List<Boolean> getPoints(){
        return this.points;
    }

    private boolean createLine(){
        if(beforeLine){
            beforeLine = false;
            return false;
        }
        boolean random = randomLine();
        beforeLine = random;
        return random;
    }

    private boolean randomLine() {
        return Math.random() > 0.5;
    }

}
