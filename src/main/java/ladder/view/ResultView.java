package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.LineEnum;
import ladder.domain.Person;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    private static final String RUN_RESULT = "실행 결과";
    private static final String EMPTY = "";
    private static final String LINE = "|";

    public ResultView() {
        System.out.println(RUN_RESULT);
    }

    public void printPerson(Person person) {
        person.readOnlyPerson().stream()
                .forEach(this::printName);
        System.out.println(EMPTY);
    }

    private void printName(String name) {
        System.out.print(String.format("%6s", name));
    }

    public void printLadder(Ladder ladder) {
        ladder.readOnlyLines().stream()
                .forEach(this::printLine);
    }

    private void printLine(Line line) {
        System.out.print(String.format("%5s", EMPTY));
        List<Boolean> points = line.readOnlyPoints();
        IntStream.range(0, points.size())
                .forEach(index -> printPoints(points, index));
        System.out.println(EMPTY);
    }

    private void printPoints(List<Boolean> points, int index) {
        System.out.print(LINE);
        if (index == points.size()-1) {
            return;
        }
        System.out.print(LineEnum.ofLine(points.get(index)));
    }
}
