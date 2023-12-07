package ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {

    private static final String HEIGHT_CANNOT_BE_LESS_THAN_ONE = "사다리 높이가 0보다 작거나 같을 수 없습니다.";

    private static final Random random = new Random();
    private List<Line> lines;

    public Ladder(int maxHeight, Players members){

        validation(maxHeight);

        lines = IntStream.rangeClosed(1, maxHeight)
                .mapToObj(i -> new Line(makeRandomLine(members.membersCount())))
                .collect(Collectors.toList());
    }

    private void validation(int maxHeight){
        if(maxHeight <= 0){
            throw new IllegalArgumentException(HEIGHT_CANNOT_BE_LESS_THAN_ONE);
        }
    }

    public List<Line> getLines(){
        return lines;
    }

    private List<Boolean> makeRandomLine(int countOfPerson){
        List<Boolean> booleanList = Stream.iterate(random.nextBoolean(), bool -> {
                    if (bool) {
                        return false;
                    }
                    return random.nextBoolean();
                })
                .limit(countOfPerson-1)
                .collect(Collectors.toList());
        return booleanList;
    }
}
