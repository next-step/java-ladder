package nextstep.ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Name;

public class OutputView {

    private static final String FOUR_SPACE = "    ";
    private static final String LADDER = "|";
    private static final String LINE = "----";

    public OutputView() {
        System.out.println("\n실행결과\n");
    }

    public void print(Ladder ladder, List<Name> names) {
        printNames(names);
        printLadder(ladder);
    }

    private void printLadder(Ladder ladder) {
        StringBuilder stringBuilder = new StringBuilder();
        ladder.getLines().forEach(line -> {
            stringBuilder.append(FOUR_SPACE);
            stringBuilder.append(line.getPoints()
                .stream()
                .map(point -> point ? LADDER + LINE : LADDER + FOUR_SPACE)
                .collect(Collectors.joining()));
            stringBuilder.append(LADDER)
                .append("\n");
        });
        System.out.println(stringBuilder);
    }

    private void printNames(List<Name> names) {
        names.stream()
            .map(name -> name + " ")
            .forEach(System.out::print);
        System.out.println();
    }
}

