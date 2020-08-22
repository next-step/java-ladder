package ladder.domain.core.line.move;

import java.util.Arrays;
import java.util.List;

import ladder.domain.core.line.Line;

public class MovableLineTestData {

   /*
      |-----|     |
      |     |-----|
      |-----|     |
   */
    static List<MovablePoints> pointsType01(int maxPointCount){
        return Arrays.asList(
            MovablePoints.of(()-> true, maxPointCount),
            MovablePoints.ofCustomLink(maxPointCount, 1),
            MovablePoints.of(()-> true, maxPointCount)
        );
    }

    public static Line type01(){
        int maxPointCount = 3;
        return new MovableLine(pointsType01(maxPointCount), maxPointCount) ;
    }
}
