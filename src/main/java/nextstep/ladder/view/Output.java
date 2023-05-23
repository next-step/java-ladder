package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Name;

import java.util.List;
import java.util.stream.Collectors;

public class Output {
    private static final String RESULT_HEADER = "실행결과\n";
    private static final String WHITE_SPACE = " ";
    private static final String HORIZONTAL_LINE_MARK = "-".repeat(Name.MAX_LENGTH);
    private static final String HORIZONTAL_NO_LINE_MARK = " ".repeat(Name.MAX_LENGTH);
    private static final String VERTICAL_LINE_MARK = "|";

    public void printResult(LadderGame ladderGame) {
        System.out.println(RESULT_HEADER);
        printName(ladderGame);
        printLadder(ladderGame);
    }

    private void printName(LadderGame ladderGame) {
        ladderGame.getNames()
                .stream()
                .map(name -> name + WHITE_SPACE.repeat(Name.MAX_LENGTH - name.length() + 1))
                .forEach(System.out::print);
        System.out.println();
    }

    private void printLadder(LadderGame ladderGame) {
        ladderGame.getLadder()
                .forEach(this::printLine);
    }

    private void printLine(List<Boolean> line) {
        String joinedLine = line.stream()
                .map(existLine -> existLine ? HORIZONTAL_LINE_MARK : HORIZONTAL_NO_LINE_MARK)
                .collect(Collectors.joining(VERTICAL_LINE_MARK, VERTICAL_LINE_MARK, VERTICAL_LINE_MARK));
        System.out.println(joinedLine);
    }
}
