package ladder.domain;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLineBuildStrategy implements LineBuildStrategy{

    private int countOfPlayer;
    private boolean previousConnection = false;
    private Random random = new Random();

    @Override
    public Line build(int countOfPlayer) {

        this.countOfPlayer = countOfPlayer;

        Line line = new Line(
        IntStream.range(0, countOfPlayer)
                .mapToObj(this::makeConnection)
                .collect(Collectors.toList()));

        return line;
    }

    private boolean makeConnection(int position){

        if(position == countOfPlayer-1){
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
