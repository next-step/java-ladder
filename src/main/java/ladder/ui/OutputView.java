package ladder.ui;

import ladder.domain.Gamer;
import ladder.domain.Gamers;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;

import java.util.stream.Collectors;

public class OutputView {
    private static final String RESULT_MSG = "실행결과";

    public void printGamers(Gamers gamers) {
        System.out.println(RESULT_MSG);
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

    public void printLadder(Ladder ladder) {
        ladder.getLines()
                .forEach(line -> System.out.println(toStringOneLine(line)));
    }

    private String toStringOneLine(Line line) {
        return line.getBars()
                .stream()
                .map(bar -> bar ? "-----" : "     ")
                .collect(Collectors.joining("|", "  |", "|"));
    }
}
