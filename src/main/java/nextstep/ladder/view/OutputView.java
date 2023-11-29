package nextstep.ladder.view;

import java.util.stream.Collectors;
import nextstep.ladder.model.Ladder;

public class OutputView {

    private static final String FOUR_SPACE = "    ";
    private static final String LADDER = "|";
    private static final String LINE = "----";

    public OutputView() {
        System.out.println("실행결과\n");
    }

    public void printLadder(Ladder ladder) {
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
}

