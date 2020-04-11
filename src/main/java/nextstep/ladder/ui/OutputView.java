package nextstep.ladder.ui;

import nextstep.ladder.domain.gamer.Gamers;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.result.Results;
import nextstep.ladder.service.LadderGameService;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String LADDER_RESULT_MSG = "사다리 결과";
    private static final String RESULT_MSG = "실행 결과";
    private static final int WORD_LIMIT = 5;
    private static final String BAR_EXIST = "-----";
    private static final String BAR_NOT_EXIST = "     ";
    private static final String LADDER_STICK = "|";
    private static final String ELLIPSIS = "..";
    private static final String LADDER_STICK_START = "  |";
    private static final String SPACE = " ";
    private static final String LADDER_RESULT_MAP_FORMAT = "%s : %s";

    public void printGamers(Gamers gamers) {
        System.out.println(LADDER_RESULT_MSG);
        System.out.println(toStringGamers(gamers.getGamers()));
    }

    private String toStringGamers(List<String> gamers) {
        return gamers
                .stream()
                .map(this::spacePadding5Center)
                .collect(Collectors.joining(SPACE));
    }

    private String spacePadding5Center(String gamer) {
        return String.format("%-5s", String.format("%4s", String.format("%-3s", String.format("%2s", gamer))));
    }

    public void printLadder(Ladder ladder) {
        ladder.getIsRightDirectionsMatrix()
                .forEach(line -> System.out.println(toStringOneLine(line)));
    }

    private String toStringOneLine(List<Boolean> line) {
        return line
                .stream()
                .map(bar -> bar ? BAR_EXIST : BAR_NOT_EXIST)
                .collect(Collectors.joining(LADDER_STICK, LADDER_STICK_START, LADDER_STICK));
    }

    public void printResultCandidate(Results resultValues) {
        String resultString = resultValues
                .getResults()
                .stream()
                .map(this::spacePadding5Center)
                .map(this::ellipsis5Character)
                .collect(Collectors.joining(SPACE));

        System.out.println(resultString);
    }

    private String ellipsis5Character(String string) {
        if (string.length() > WORD_LIMIT) {
            return string.substring(0, WORD_LIMIT - 2) + ELLIPSIS;
        }
        return string;
    }

    public void printResult(String result) {
        System.out.println(RESULT_MSG);
        System.out.println(result);
    }

    public void printResultAll(Gamers gamers, LadderGameService ladderGameService) {
        System.out.println(RESULT_MSG);
        gamers.getGamers()
                .forEach(gamer -> System.out.println(
                        String.format(LADDER_RESULT_MAP_FORMAT, gamer, ladderGameService.getResult(gamer))));
    }
}
