package ladder.view;

import ladder.domain.Line;
import ladder.domain.LineState;
import ladder.domain.Winning;
import ladder.dto.Name;
import ladder.dto.Results;

import java.util.List;
import java.util.Optional;

public class ResultView {

    private static final String BOUNDARY = "|";
    private static final String BLANK = " ";
    private static final String SEPARATOR = " : ";

    public void print(List<Name> names, List<Line> ladder) {
        System.out.println("사다리 결과");
        System.out.println();

        names.forEach(name -> System.out.print(name.getName() + BLANK));
        System.out.println();

        ladder.forEach(this::printLadder);
    }

    private void printLadder(Line line) {
        line.getPoints()
                .forEach(point -> System.out.print(BOUNDARY + LineState.state(point)));
        System.out.println();
    }

    public void printResultList(Results results) {
        results.getResults()
                .forEach(result -> System.out.print(result + BLANK));
        System.out.println();
    }

    public void printResult(Winning winning, String person) {
        System.out.println("실행 결과.");
        if (!person.equals("all")) {
            System.out.println(Optional.ofNullable(winning.getWinning()
                    .get(new Name(person)))
                    .orElseThrow(IllegalArgumentException::new));
            return;
        }
        printResultPeople(winning);
    }

    private void printResultPeople(Winning winning) {
        winning.getWinning()
                .keySet()
                .forEach(name -> System.out.println(name.getName() + SEPARATOR + winning.getWinning().get(name)));
    }
}
