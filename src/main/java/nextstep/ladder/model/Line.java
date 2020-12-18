package nextstep.ladder.model;

import java.util.*;

public class Line {
    private List<Boolean> points = new ArrayList<>();
    Random random = new Random();

    public Line (int countOfPerson){
       points.add(random.nextBoolean());
       for(int i = 1;i < countOfPerson-1;i++){
           points.add(isPreLine(i));
       }
    }

    public boolean isPreLine(int point){
        return points.get(point-1) ? false : random.nextBoolean();
    }

    public List<Boolean> getPoints(){
        return Collections.unmodifiableList(points);
    }

}