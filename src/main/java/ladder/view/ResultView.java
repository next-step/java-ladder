package ladder.view;

import ladder.model.Ladder;
import ladder.model.Participant;
import ladder.model.Participants;
import ladder.model.Point;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    public static void printResult(Participants participants, Ladder ladder) {
        System.out.println("실행 결과");

        printParticipants(participants.getParticipants());
        ladder.getLines().stream()
                .forEach(line -> printLine(line.getPoints()));
    }

    private static void printParticipants(List<Participant> participants) {
        System.out.println(participants.stream()
                .map(participant -> {
                    String name = participant.toString();
                    int countOfLeftPad = 5 - name.length();
                    return countOfLeftPad > 0 ? leftWhitespacePad(name, countOfLeftPad) : name;
                }).collect(Collectors.joining(" ")));
    }

    private static void printLine(List<Point> points) {
        System.out.println(points.stream()
                .map(point -> point == Point.from(true) ? "-----" : "     ")
                .collect(Collectors.joining("|", "    |", "|")));
    }

    private static String leftWhitespacePad(String value, int countOfPad) {
        return IntStream.range(0, countOfPad)
                .mapToObj(index -> " ").collect(Collectors.joining()) + value;
    }
}
