package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.gift.Gift;
import nextstep.ladder.domain.gift.GiftBundle;
import nextstep.ladder.domain.ladder.size.LadderHeight;
import nextstep.ladder.domain.ladder.size.LadderSize;
import nextstep.ladder.domain.ladder.size.LadderWidth;
import nextstep.ladder.domain.rule.RandomWayRule;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.unmodifiableList;
import static nextstep.ladder.utils.Validation.checkNotNull;

public class LadderGame {

    private static final int MIN_NUMBER_OF_PARTICIPANTS = 2;
    private static final int MIN_INDEX = 0;
    private static final RandomWayRule DEFAULT_WAY_RULE = new RandomWayRule();

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
        if (participants == null || participants.size() < MIN_NUMBER_OF_PARTICIPANTS) {
            throw new TooFewParticipantsException(MIN_NUMBER_OF_PARTICIPANTS);
        }
    }

    public static LadderGame of(List<Participant> participants, LadderHeight ladderHeight) {
        checkNotNull(participants, ladderHeight);
        LadderWidth ladderWidth = new LadderWidth(participants.size());
        return new LadderGame(participants, createLadder(ladderWidth, ladderHeight));
    }

    private static Ladder createLadder(LadderWidth ladderWidth, LadderHeight ladderHeight) {
        LadderSize ladderSize = new LadderSize(ladderWidth, ladderHeight);
        return Ladder.of(ladderSize, DEFAULT_WAY_RULE);
    }

    public GameResult play(GiftBundle giftBundle) {
        checkGiftBundleSize(giftBundle);

        Map<Participant, Gift> results = new LinkedHashMap<>();
        for (int position = MIN_INDEX; position < participants.size(); position++) {
            int resultPosition = ladder.move(position);
            results.put(participants.get(position), giftBundle.gift(resultPosition));
        }
        return new GameResult(results);
    }

    private void checkGiftBundleSize(GiftBundle giftBundle) {
        if (giftBundle == null || !giftBundle.hasSize(participants.size())) {
            throw new InvalidNumberOfGiftsException();
        }
    }

    public List<Participant> participants() {
        return unmodifiableList(participants);
    }

    public Ladder getLadder() {
        return ladder;
    }
}
