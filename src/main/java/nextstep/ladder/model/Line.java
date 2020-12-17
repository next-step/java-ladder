package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line (int countOfPerson){
        //라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
        Random random = new Random();

        points.add(random.nextBoolean());
        for(int point = 1;point < countOfPerson;point++){

            if(points.get(point-1)){
                points.add(false);
                continue;
            }
            points.add(random.nextBoolean());


        }

    }

    public List<Boolean> getPoints(){
        return points;
    }


}