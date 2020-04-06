package ladder.ui;

import ladder.domain.Gamer;
import ladder.domain.Gamers;
import ladder.domain.dto.BarMatrixDto;
import ladder.domain.dto.LadderResultDto;
import ladder.domain.ladder.Bar;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderResult;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String LADDER_RESULT_MSG = "사다리 결과";
    private static final String RESULT_MSG = "실행 결과";
    private static final int WORD_LIMIT = 5;
    private static final String BAR_EXIST = "-----";
    private static final String BAR_NOT_EXIST = "     ";
    private static final String LADDER_STICK = "|";
    private static final String ELLIPSIS = "|";

    public void printGamers(Gamers gamers) {
        System.out.println(LADDER_RESULT_MSG);
        System.out.println(toStringGamers(gamers));
    }

    private String toStringGamers(Gamers gamers) {
        return gamers.getGamerList()
                .stream()
                .map(Gamer::getName)
                .map(this::spacePadding5Center)
                .collect(Collectors.joining(" "));
    }

    private String spacePadding5Center(String gamer) {
        return String.format("%-5s", String.format("%4s", String.format("%-3s", String.format("%2s", gamer))));
    }

    public void printLadder(BarMatrixDto ladder) {
        ladder.getBarMatrix()
                .forEach(line -> System.out.println(toStringOneLine(line)));
    }

    private String toStringOneLine(List<Bar> line) {
        return line
                .stream()
                .map(Bar::isExist)
                .map(bar -> bar ? BAR_EXIST : BAR_NOT_EXIST)
                .collect(Collectors.joining(LADDER_STICK, "  " + LADDER_STICK, LADDER_STICK));
    }

    public void printResultCandidate(LadderResult ladderResult) {
        String resultString = ladderResult.getResults()
                .stream()
                .map(this::spacePadding5Center)
                .map(this::ellipsis5Character)
                .collect(Collectors.joining(" "));

        System.out.println(resultString);
    }

    private String ellipsis5Character(String string) {
        if (string.length() > WORD_LIMIT) {
            return string.substring(0, 3) + ELLIPSIS;
        }
        return string;
    }

    public void printResult(String result) {
        System.out.println(RESULT_MSG);
        System.out.println(result);
    }

    public void printResultAll(Gamers gamers, LadderResultDto ladderResult) {
        System.out.println(RESULT_MSG);
        gamers.getGamerList()
                .stream()
                .map(Gamer::getName)
                .forEach(gamer -> System.out.println(gamer + " : " + ladderResult.getResult(gamer)));
    }
}
