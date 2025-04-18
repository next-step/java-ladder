package ladder.view;

import ladder.domain.Line;
import ladder.domain.Lines;
import ladder.domain.Names;
import ladder.domain.Rung;

import java.util.stream.Collectors;

public class OutputView {
    public void printNames(Names names) {
        System.out.println("실행결과");
        System.out.println();

        names.getAll().stream()
                .map(name -> String.format("%5s ", name))
                .forEach(System.out::print);

        System.out.println();
    }

    public void printLadder(Lines lines) {
        lines.getLines().stream()
                .map(this::convertLine)
                .forEach(System.out::println);
    }

    private String convertLine(Line line) {
        return line.getRungs().stream()
                .map(this::convertRung)
                .collect(Collectors.joining("|", "    |", "|"));
    }

    private String convertRung(Rung rung) {
        return rung.isConnected() ? "-----" : "     ";
    }
}
