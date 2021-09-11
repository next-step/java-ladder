package ladder.helper;

import ladder.domain.game.GameResult;
import ladder.domain.ladder.*;
import ladder.domain.participant.Participant;
import ladder.domain.participant.Participants;
import ladder.domain.position.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Fixture {
//    private static String[] participantNames = Stream.of("man1", "man2", "man3", "man4", "man5", "man6", "man7", "man8", "man9", "man10").toArray(String[]::new);
    private static int ladderHeight = 2;
    private static String[] prizeName = Stream.of("prz1", "prz2", "prz3", "prz4", "prz5", "prz6", "prz7", "prz8", "prz9", "prz10").toArray(String[]::new);
    private static Participant participant = new Participant("man3", new Position(2, ladderSize()));


    public static String[] participantNames() {
        return Stream.of("man1", "man2", "man3", "man4", "man5", "man6", "man7", "man8", "man9", "man10").toArray(String[]::new);
    }

    public static String[] prizeName() {
        return prizeName;
    }

    public static LadderSize ladderSize() {
        return new LadderSize(participantNames().length, ladderHeight);
    }

    public static List<Boolean> generatedLines() {
        return new ArrayList<>(Arrays.asList(true, false, true, false, true, false, true, false, true));
    }

    public static Participants participants() {
        return new Participants(participantNames(), ladderSize());
    }

    public static Participant participant() {
        return new Participant("man3", new Position(2, ladderSize()));
    }
    public static void runGame() {
        Participants participants = participants();
        Ladder ladder = Ladder.create(ladderSize(), AutoLineGenerator.create());
        participants.moveToDestination(ladder.getFloors());
    }

    public static GameResult gameResult() {
        return new GameResult(participants(), prizeName(), ladderSize());
    }

    public static Ladder ladder() {
        return Ladder.of(
                Arrays.asList(
                        new LadderFloor(Arrays.asList(true, false, true, false, true, false, true, false, true)),
                        new LadderFloor(Arrays.asList(false, true, false, true, false, true, false, true, false))
                )
        );
    }
}
