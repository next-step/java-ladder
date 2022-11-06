package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static final int COUNT_OF_PERSON_MIN = 1;

    public static void main(String[] args) {
        List<Name> names = InputView.queryNames();
        int countOfPerson = names.size();
        if (countOfPerson <= COUNT_OF_PERSON_MIN) {
            throw new IllegalArgumentException("참여 인원이 너무 적습니다.");
        }
        LadderMaxHeight maxHeight = InputView.queryMaxHeight();

        List<Line> lines = Stream.generate(() -> LineFactory.randomLine(names.size()))
                .limit(maxHeight.getValue())
                .collect(Collectors.toList());

        ResultView.printNames(names);
        ResultView.printLines(lines);
    }
}
