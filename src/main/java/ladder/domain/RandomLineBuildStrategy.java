package ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class RandomLineBuildStrategy implements LineBuildStrategy{

    private static final int FIRST_INDEX = 0;

    private boolean previousConnection = false;

    private Random random = new Random();

    @Override
    public Line build(int ladderCount) {

        List<Point> pointList = IntStream.range(0, ladderCount-1)
                .mapToObj(this::makeDirection)
                .map(Point::new)
                .collect(Collectors.toList());

        makeLastPoint(pointList);

        return new Line(pointList);
    }

    private void makeLastPoint(List<Point> pointList) {
        pointList.add(new Point(Direction.of(pointList.get(pointList.size()-1).getDirection().isRight(), false)));
    }

    private Direction makeDirection(int position){

        if(position == FIRST_INDEX){
            previousConnection = false;
        }

        if(previousConnection){
            previousConnection = false;
            return Direction.of(true, false);
        }

        previousConnection = random.nextBoolean();

        return Direction.of(false, previousConnection);

    }

}
