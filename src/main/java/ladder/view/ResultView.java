package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String VERTICAL_LINE = "|";
    private static final String MOVABLE_LINE = "-----";
    private static final String IMMOVABLE_LINE = "     ";

    private static void printStart() {
        newLine();
        System.out.println("사다리 결과");
        newLine();
    }

    public static void printLadder(Participants participants, Ladder ladder, Results results) {
        printStart();
        printParticipants(participants);
        printLadder(ladder, participants.countOfParticipants());
        printResults(results);
    }

    private static void printParticipants(Participants participantsInput) {
        List<Person> participants = participantsInput.getParticipants();

        participants.stream()
                .map(Person::getName)
                .forEach(name -> System.out.printf("%-6s", name));

        newLine();
    }

    private static void printLadder(Ladder ladder, int countOfParticipants) {
        ladder.getLines()
                .getLineCollection()
                .forEach(line -> printLadderLine(line, countOfParticipants));
    }


    private static void printResults(Results resultsInput) {
        List<Result> results = resultsInput.getResults();

        results.stream()
                .map(Result::getName)
                .forEach(name -> System.out.printf("%-6s", name));

        newLine();
    }

    public static void printAllResults(Map<String, String> allResults) {
        for (Map.Entry<String, String> result : allResults.entrySet()) {
            System.out.println(result.getKey() + " : " + result.getValue());
        }
    }


    private static void printLadderLine(Line line, int countOfParticipants) {
        int index = 0;
        int pointSize = countOfParticipants - 1;

        for (Point point : line.getPoints()) {
            System.out.print(VERTICAL_LINE);

            String movableLine = point.getPoint() ? MOVABLE_LINE : IMMOVABLE_LINE;
            System.out.print(movableLine);

            printEndVerticalLine(++index, pointSize);
        }
        newLine();
    }

    private static void printEndVerticalLine(int index, int pointSize) {
        if (index == pointSize) {
            System.out.print(VERTICAL_LINE);
        }
    }

    private static void newLine() {
        System.out.print(System.lineSeparator());
    }

    public static void printResult(String name) {
        newLine();
        System.out.println("사다리 결과");
        System.out.println(name);
    }
}
