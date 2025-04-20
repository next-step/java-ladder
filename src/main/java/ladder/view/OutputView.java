package ladder.view;

import ladder.domain.*;

import java.util.stream.Collectors;

public class OutputView {
    public void printLadder(Ladder ladder) {
        System.out.println("사다리 결과");
        System.out.println();

        printNames(ladder.getNames());
        printLines(ladder.getLines());
        printPrizes(ladder.getPrizes());
        System.out.println();
    }

    private void printNames(Names names) {
        names.getAll().stream()
                .map(name -> String.format("%5s ", name))
                .forEach(System.out::print);
        System.out.println();
    }

    private void printLines(Lines lines) {
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

    private void printPrizes(Prizes prizes) {
        prizes.getPrizes().stream()
                .map(name -> String.format("%5s ", name))
                .forEach(System.out::print);
        System.out.println();
    }

    public void printResult(Results result, String name) {
        System.out.println("실행 결과");
        System.out.println(result.getResult(name));
        System.out.println();
    }

    public void printAllResult(Results result) {
        System.out.println("실행 결과");
        result.getResult().entrySet().stream()
                .map(entry -> String.format("%s : %s", entry.getKey(), entry.getValue()))
                .forEach(System.out::println);
    }
}
