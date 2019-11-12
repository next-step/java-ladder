package step2.view;

import step2.domain.Ladder;
import step2.domain.Line;
import step2.domain.Participants;
import step2.domain.Person;

import java.util.List;

public class ResultView {
    private static final String VERTICAL_LINE = "|";
    private static final String MOVABLE_LINE = "-----";
    private static final String IMMOVABLE_LINE = "     ";

    public static void printStart() {
        newLine();
        System.out.println("실행결과");
        newLine();
    }

    public static void printParticipants(Participants participantsInput) {
        List<Person> participants = participantsInput.getParticipants();

        participants.stream()
                .map(Person::getName)
                .forEach(name -> System.out.printf("%-6s", name));

        newLine();
    }

    public static void printLadder(Ladder ladder, int countOfParticipants) {
        ladder.getLines()
                .forEach(line -> printLadderLine(line, countOfParticipants));
    }

    private static void printLadderLine(Line line, int countOfParticipants) {
        int index = 0;
        int pointSize = countOfParticipants - 1;

        for (Boolean point : line.getPoints()) {
            System.out.print(VERTICAL_LINE);

            String movableLine = point ? MOVABLE_LINE : IMMOVABLE_LINE;
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

}
