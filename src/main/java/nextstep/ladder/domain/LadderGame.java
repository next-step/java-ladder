package nextstep.ladder.domain;

import java.util.List;

import static java.lang.String.format;
import static nextstep.ladder.utils.Validator.checkNotNull;

public class LadderGame {

    private static final int PARTICIPANTS_MIN_SIZE = 2;
    private static final String TOO_FEW_PARTICIPANTS_ERROR_MESSAGE = format("참가자는 %d명 이상이어야 합니다.", PARTICIPANTS_MIN_SIZE);
    private static final int DIFFERENCE_BETWEEN_PARTICIPANTS_SIZE_AND_WIDTH = 1;

    private final List<Participant> participants;
    private final Ladder ladder;

    public LadderGame(List<Participant> participants, Ladder ladder) {
        checkArguments(participants, ladder);
        this.participants = participants;
        this.ladder = ladder;
    }

    private static void checkArguments(List<Participant> participants, Ladder ladder) {
        checkParticipantsSize(participants);
        checkNotNull(ladder);
    }

    private static void checkParticipantsSize(List<Participant> participants) {
        if (participants == null || participants.size() < PARTICIPANTS_MIN_SIZE) {
            throw new IllegalArgumentException(TOO_FEW_PARTICIPANTS_ERROR_MESSAGE);
        }
    }

    public static LadderGame of(List<Participant> participants, Positive height) {
        checkNotNull(participants);
        Positive width = widthOf(participants);
        return new LadderGame(participants, createLadder(width, height));
    }

    private static Positive widthOf(List<Participant> participants) {
        int width = participants.size() - DIFFERENCE_BETWEEN_PARTICIPANTS_SIZE_AND_WIDTH;
        return new Positive(width);
    }

    private static Ladder createLadder(Positive width, Positive height) {
        LadderSize ladderSize = new LadderSize(width, height);
        PointRule pointRule = new RandomPointRule();
        return Ladder.of(ladderSize, pointRule);
    }

    public Gift play(Participant participant, GiftBundle giftBundle) {
        checkArguments(participant, giftBundle);
        Position resultPosition = ladder.play(findPositionOf(participant));
        return giftBundle.gift(resultPosition);
    }

    private Position findPositionOf(Participant participant) {
        return new Position(participants.indexOf(participant));
    }

    private void checkArguments(Participant participant, GiftBundle giftBundle) {
        checkRegisteredParticipant(participant);
        checkNotNull(giftBundle);
        giftBundle.checkSizeEquals(participants.size());
    }

    private void checkRegisteredParticipant(Participant participant) {
        if (!participants.contains(participant)) {
            throw new IllegalArgumentException("참여하지 않는 참가자입니다.");
        }
    }

}
