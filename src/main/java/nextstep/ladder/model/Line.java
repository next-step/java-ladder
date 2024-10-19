package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points = new ArrayList<>();
    private LineGenerator lineGenerator;

    public Line (int countOfPerson, LineGenerator lineGenerator){
        for(int i=0; i<countOfPerson - 1; i++){
            if(i == 0){
                points.add(lineGenerator.generate());
            }
            else{
                points.add(!points.get(i - 1) && lineGenerator.generate());
            }
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
