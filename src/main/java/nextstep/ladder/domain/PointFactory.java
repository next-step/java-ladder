package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PointFactory {
    static List<Point> of(int countOfPerson, PointGenerator pointGenerator){
        if(countOfPerson < 2){
            throw new IllegalArgumentException("count of person must be more than one");
        }

        List<Point> points = new ArrayList<>(Arrays.asList(pointGenerator.first()));

        for(int i = 1; i < countOfPerson-1 ; i++){
           Point point = pointGenerator.nextPoint(points.get(i-1));
           points.add(point);
        }

        return points;
    }

    static List<Point> of(int countOfPerson){
        return of(countOfPerson, new RandomPointGenerator());
    }
}
