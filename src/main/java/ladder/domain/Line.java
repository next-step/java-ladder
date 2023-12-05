package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {

    private List<Boolean> points = new ArrayList<>();

    private static final Random random = new Random();

    private static final String CONSECUTIVE_TRUES_CANNOT_BE_ENTERED = "Line을 생성할 때 true가 연속으로 들어올 수 없습니다.";

    public Line(int countOfPerson) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
        List<Boolean> line = makeRandomLine(countOfPerson);
        validation(line);
        this.points = line;
    }

    public Line(List<Boolean> list) {
        validation(list);
        this.points = list;
    }

    private void validation(List<Boolean> list){
        for (int i = 1; i < list.size(); i++) {
            continuousLineValidation(list, i);
        }
    }

    private static void continuousLineValidation(List<Boolean> list, int i) {
        if(list.get(i) == true){
            List<Boolean> consecutiveElements = new ArrayList<>();
            consecutiveElements.add(list.get(i - 1));
            consecutiveElements.add(list.get(i));

            boolean areConsecutiveEqual = consecutiveElements.stream()
                    .distinct()
                    .count() == 1;

            inCaseOfConsecutive(areConsecutiveEqual);
        }
    }

    private static void inCaseOfConsecutive(boolean areConsecutiveEqual) {
        if (areConsecutiveEqual) {
            throw new RuntimeException(CONSECUTIVE_TRUES_CANNOT_BE_ENTERED);
        }
    }

    private List<Boolean> makeRandomLine(int countOfPerson){
        List<Boolean> booleanList = Stream.iterate(random.nextBoolean(), bool -> {
            if (bool) {
                return false;
            } else {
                return random.nextBoolean();
            }
        }).limit(countOfPerson-1).collect(Collectors.toList());
        return booleanList;
    }

    public Stream<Boolean> stream() {
        return this.points.stream();
    }

}
