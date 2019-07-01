package ladder.Model;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Boolean> points = new ArrayList <>();
    private boolean beforeLine = false;

    public Line(int countOfPerson) {
        for (int i = 1; i < countOfPerson; i++) {
            createLine();
        }
    }

    private void createLine(){
        if(beforeLine){
            points.add(false);
            beforeLine = false;
        }
        boolean random = randomLine();
        points.add(random);
        beforeLine = random;
    }

    private boolean randomLine() {
        return Math.random() > 0.5;
    }

}
