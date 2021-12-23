package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    private static final int NAME_SPACE_SIZE = 6;
    private static final String NAME_SPACE = "      ";
    private static final String PILLAR = "|";
    private static final String CONNECTED_LINE = "-----";
    private static final String EMPTY_LINE = "     ";

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

    private void printLadder(final Ladder ladder) {
        ladder.getLadderLines().forEach(this::printLine);
    }

    private void printLine(final LadderLine line) {
        line.getPoints().forEach(point -> System.out.print(printBetweenLine(point) + PILLAR));
        System.out.println();
    }

    private static String printBetweenLine(final Point point) {
        if (point.hasLeftDirectionLine()) {
            return CONNECTED_LINE;
        }
        return EMPTY_LINE;
    }

    public void printResultALL(Participants participants, Ladder ladder, Prizes prizes) {
        System.out.println("실행 결과");
        participants.getParticipants().forEach(
                participant -> {
                    System.out.println(participant.getName() + " : " + prizes.getPrizeName(participant.getPrizeIndex(ladder)));
                }
        );
    }

    public void printPrizeResult(Prizes prizes, int index) {
        System.out.println("실행 결과");
        System.out.println(prizes.getPrizeName(index));
    }
}
