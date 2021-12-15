package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.domain.Prizes;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    private static final int NAME_SPACE_SIZE = 6;
    private static final String NAME_SPACE = "      ";

    public void printLadder(List<String> participantNames, Ladder ladder, List<String> prizeNames) {
        System.out.println("사다리 결과");
        this.printNames(participantNames);
        this.printLadder(ladder);
        this.printNames(prizeNames);
    }

    private void printNames(List<String> names) {
        names.stream()
                .map(this::transform)
                .forEach(System.out::print);
        System.out.println();
    }

    private String transform(String name) {
        char[] array = NAME_SPACE.toCharArray();
        int nameSize = name.length();
        IntStream.range(0, nameSize).forEach(i -> array[NAME_SPACE_SIZE - nameSize + i] = name.charAt(i));
        return String.valueOf(array);
    }

    public void printLadder(Ladder ladder) {
        ladder.getFloors().forEach(floor -> {
            floor.getLines().forEach(this::printLine);
            System.out.println();
        });
    }

    private void printLine(Boolean point) {
        if (point) {
            System.out.print("-----|");
            return;
        }
        System.out.print("     |");
    }

    public void printResult(Participants participants, Prizes prizes, String name) {
        System.out.println("실행 결과");
        if (name.equals("all")) {
            participants.getParticipants().forEach(
                    participant -> System.out.println(participant.getName() + " : " + prizes.getPrizeName(participant.getSection() - 1))
            );
            return;
        }
        System.out.println(prizes.getPrizeName(participants.getParticipantSection(name) - 1));
    }
}
