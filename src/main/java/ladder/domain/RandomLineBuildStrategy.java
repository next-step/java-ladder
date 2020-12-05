package ladder.domain;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLineBuildStrategy implements LineBuildStrategy{

    private int ladderCount;
    private boolean previousConnection = false;
    private Random random = new Random();

    @Override
    public Line build(int ladderCount) {

        this.ladderCount = ladderCount;

        Line line = new Line(
        IntStream.range(0, ladderCount)
                .mapToObj(this::makeConnection)
                .collect(Collectors.toList()));

        return line;
    }

    private boolean makeConnection(int position){

        if(position == ladderCount-1){
            return false;
        }

        if(previousConnection){
            previousConnection = false;
            return false;
        }

        previousConnection = random.nextBoolean();

        return previousConnection;

    }


}
