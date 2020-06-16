package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Participants;
import ladder.domain.Person;

import static ladder.utils.LadderUtil.fillSpace;

public class ResultView {
    private ResultView() {}

    public static void printLadder(Participants participants, Ladder ladder) {
        System.out.println("실행결과\n");

        participants.getParticipants().stream()
                .map(person -> fillSpace(person.getName()))
                .forEach(System.out::print);
        System.out.println();

        for (Line line : ladder.getLadder()) {
            System.out.println(line.drawLadderLine());
        }
    }
}
