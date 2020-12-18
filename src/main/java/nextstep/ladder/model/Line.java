package nextstep.ladder.model;

import java.util.*;

public class Line {
    private List<Boolean> points = new ArrayList<>();
    Random random = new Random();

    public Line (int countOfPerson){
        //라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
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