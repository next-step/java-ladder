package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points = new ArrayList<>();
    private LineGenerator lineGenerator;

    public Line (int countOfPlayers, LineGenerator lineGenerator){
        this.lineGenerator = lineGenerator;
        for(int i=0; i<countOfPlayers - 1; i++){
            if(i == 0){
                points.add(this.lineGenerator.generate());
            }
            else{
                points.add(!points.get(i - 1) && this.lineGenerator.generate());
            }
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
