package ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {
    private final List<Boolean> points;

    public Line(int countOfPerson) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
        this.points = Stream.iterate(new Random().nextBoolean(), b -> b? false : new Random().nextBoolean())
                .limit(countOfPerson - 1)
                .collect(Collectors.toList());
    }

    public List<Boolean> points() {
        return this.points;
    }


//    public String toLine() {
//        this.points
//                .stream()
//                .map(p -> p? "-" : " ")
//                .map(p -> p.repeat(5) + "|")
//                .reduce("", (acc, cur) -> acc + cur);
//    }
}
