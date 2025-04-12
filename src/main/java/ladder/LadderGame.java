package ladder;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private final int NAME_WIDTH = 5;
    private final List<String> participants;
    private final Ladder ladder;

    public LadderGame(List<String> participants, int height) {
        this.participants = participants;
        this.ladder = new Ladder(height, participants.size());
    }

    public void printLadder() {
        String nameRow = participants.stream()
                .map(name -> String.format("%-" + NAME_WIDTH + "s", name))
                .collect(Collectors.joining(" "));
        System.out.println(nameRow);

        ladder.getLines().forEach(line -> System.out.println(line.draw()));
    }

}