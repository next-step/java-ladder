package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ResultView {
    private static final String RUN_RESULT = "실행 결과";
    private static final String LADDER_RESULT = "결과를 보고 싶은 사람은?";
    private static final String EMPTY = "";
    private static final String LINE = "|";
    private static final String ALL_RESULT_KEYWORD = "all";

    private final Persons persons;

    public ResultView(Persons persons) {
        System.out.println(RUN_RESULT);
        this.persons = persons;
    }

    public void printPersons() {
        persons.readOnlyPersons()
                .forEach(this::printName);
        System.out.println(EMPTY);
    }

    private void printName(Person person) {
        System.out.print(String.format("%6s", person.name()));
    }

    public void printLadder(Ladder ladder) {
        ladder.readOnlyLines()
                .forEach(this::printLine);
    }

    private void printLine(Line line) {
        System.out.print(String.format("%5s", EMPTY));
        List<Boolean> points = line.readOnlyPoints();
        IntStream.range(0, points.size())
                .forEach(index -> printPoints(points, index));
        System.out.println(EMPTY);
    }

    private void printPoints(List<Boolean> points, int index) {
        System.out.print(LINE);
        if (index == points.size()-1) {
            return;
        }
        System.out.print(LineEnum.ofLine(points.get(index)));
    }

    public void printWinnings(Winnings winning) {
        winning.readOnlyWinning()
                .forEach(this::printWinning);
        System.out.println(EMPTY);
    }

    private void printWinning(Winning winning) {
        System.out.print(String.format("%6s", winning.winning()));
    }

    public void printLadderResult(LadderResult ladderResult) {
        Scanner scanner = new Scanner(System.in);
        boolean isResult = true;

        while(isResult) {
            System.out.println(EMPTY);
            System.out.println(LADDER_RESULT);
            isResult = printResults(scanner.next(), ladderResult);
        }
    }

    private boolean printResults(String name, LadderResult ladderResult) {
        System.out.println(EMPTY);
        System.out.println(RUN_RESULT);
        if (ALL_RESULT_KEYWORD.equals(name)) {
            persons.readOnlyPersons()
                    .forEach(person -> {
                        String key = person.name();
                        printResult(key, ladderResult.resultOfLadder(key));
                    });
            return false;
        }
        try {
            printResult(name, ladderResult.resultOfLadder(name));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(EMPTY);
        }
        return true;
    }

    private void printResult(String name, Winning winning) {
        System.out.println(name + " : " + winning.winning());
    }
}
