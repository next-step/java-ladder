package nextstep.ladder;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {

    public static final int MAX_PERSON_SIZE = 1;
    private List<Boolean> points;
    private Random random = new Random();

    public Line (int countOfPerson) {
        if (countOfPerson <= MAX_PERSON_SIZE) {
             throw new IllegalArgumentException("라인은 1명 이상인 경우만 생성 됩니다");
        }
        this.points = Stream.iterate(random.nextBoolean(), this::hasLine)
                .limit(countOfPerson-1)
                .collect(Collectors.toList());
    }

    private boolean hasLine(Boolean b) {
        return b == true ? false : random.nextBoolean();
    }


}
