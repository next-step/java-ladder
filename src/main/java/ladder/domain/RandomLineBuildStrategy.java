package ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ladder.domain.LadderGameConfig.FIRST_INDEX;

public class RandomLineBuildStrategy implements LineBuildStrategy{
    private boolean previousConnection = false;
    private Random random = new Random();

    @Override
    public Line build(int ladderCount) {

        List<Point> pointList = IntStream.range(0, ladderCount-1)
                .mapToObj(this::makeDirection)
                .map(Point::new)
                .collect(Collectors.toList());

       ;
        pointList.add(new Point(new Direction( pointList.get(pointList.size()-1).getDirection().isRight(), false)));

        return new Line(pointList);
    }

    private Direction makeDirection(int position){

        if(position == FIRST_INDEX){
            previousConnection = false;
        }

        if(previousConnection){
            previousConnection = false;
            return new Direction(true, false);
        }

        previousConnection = random.nextBoolean();

        return new Direction(false, previousConnection);

    }

}
