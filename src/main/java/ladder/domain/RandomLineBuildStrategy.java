package ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLineBuildStrategy implements LineBuildStrategy{
    private boolean previousConnection = false;
    private Random random = new Random();

    @Override
    public Line build(int ladderCount) {

        List<Point> pointList = IntStream.range(0, ladderCount-1)
                .mapToObj(this::makeConnection)
                .map(Point::new)
                .collect(Collectors.toList());

        pointList.add(new Point(false));

        return new Line(pointList);
    }

    private boolean makeConnection(int position){

        if(previousConnection){
            previousConnection = false;
            return false;
        }

        previousConnection = random.nextBoolean();

        return previousConnection;

    }

}
