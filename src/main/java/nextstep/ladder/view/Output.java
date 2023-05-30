package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Name;

import java.util.List;
import java.util.stream.Collectors;

public class Output {
    private static final String LADDER_RESULT_HEADER = "사다리 결과";
    private static final String RESULT_HEADER = "실행 결과";
    private static final String WHITE_SPACE = " ";
    private static final String HORIZONTAL_LINE_MARK = "-".repeat(Name.MAX_LENGTH);
    private static final String HORIZONTAL_NO_LINE_MARK = " ".repeat(Name.MAX_LENGTH);
    private static final String VERTICAL_LINE_MARK = "|";

    public static void printLadderResult(LadderGame ladderGame) {
        System.out.println(LADDER_RESULT_HEADER);
        System.out.println();
        printName(ladderGame);
        printLadder(ladderGame);
        printPrize(ladderGame);
        System.out.println();
    }

    private static void printName(LadderGame ladderGame) {
        ladderGame.getNames()
                .stream()
                .map(name -> name + WHITE_SPACE.repeat(Name.MAX_LENGTH - name.length() + 1))
                .forEach(System.out::print);
        System.out.println();
    }

    private static void printLadder(LadderGame ladderGame) {
        ladderGame.getLadder()
                .forEach(Output::printLine);
    }

    private static void printLine(List<Boolean> line) {
        String joinedLine = line.stream()
                .map(existLine -> existLine ? HORIZONTAL_LINE_MARK : HORIZONTAL_NO_LINE_MARK)
                .collect(Collectors.joining(VERTICAL_LINE_MARK, VERTICAL_LINE_MARK, VERTICAL_LINE_MARK));
        System.out.println(joinedLine);
    }

    private static void printPrize(LadderGame ladderGame) {
        ladderGame.getPrizes()
                .stream()
                .map(prize -> prize + WHITE_SPACE.repeat(Math.max(Name.MAX_LENGTH - prize.length() + 1, 0)))
                .forEach(System.out::print);
        System.out.println();
    }

    public static void printResult(LadderGame ladderGame, String nameToShowResult) {
        System.out.println(RESULT_HEADER);
        if (nameToShowResult.equals("all")) {
            ladderGame.getNames()
                    .forEach(name -> System.out.println(name + " : " + ladderGame.calculatePrize(name)));
            return;
        }
        System.out.println(ladderGame.calculatePrize(nameToShowResult));
    }
}
