package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Participants;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void showParticipants(Participants participants) {
        List<String> names = participants.names()
                .stream()
                .map(name -> String.format("%6s", name))
                .collect(Collectors.toList());
        System.out.println(String.join("", names));
    }

    public static void showLadder(Ladder ladder) {
        ladder.getLines()
                .stream()
                .map(Line::lineToString)
                .forEach(System.out::println);
    }
}
