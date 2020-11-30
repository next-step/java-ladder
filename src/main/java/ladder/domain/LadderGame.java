package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderLine;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;
import ladder.domain.user.User;
import ladder.domain.user.Users;

import java.util.List;
import java.util.Map;

import static util.Preconditions.checkArgument;

public class LadderGame {
    public static final String USERS_AND_PRIZES_SIZE_MUST_BE_EQUAL = "users and prizes size must be equal";

    private final Ladder ladder;
    private final LadderGameResult ladderGameResult = new LadderGameResult();

    private LadderGame(final Ladder ladder) {
        this.ladder = ladder;
    }

    public static LadderGame of(final int userCount, final int ladderHeight) {
        final Ladder ladder = Ladder.of(userCount, ladderHeight);
        return new LadderGame(ladder);
    }

    public Map<String, String> play(final Users users, final Prizes prizes) {
        checkArgument(users.size() == prizes.size(), USERS_AND_PRIZES_SIZE_MUST_BE_EQUAL);
        if (isAlreadyFinished()) {
            return ladderGameResult.toDTO();
        }

        for (int i = 0; i < users.size(); i++) {
            saveResult(i, users, prizes);
        }
        return ladderGameResult.toDTO();
    }

    private void saveResult(final int startPosition, final Users users, final Prizes prizes) {
        final User user = users.findUserByPosition(startPosition);
        final int lastPosition = ladder.startAt(startPosition);
        final Prize prize = prizes.findPrizeByPosition(lastPosition);
        ladderGameResult.put(user, prize);
    }

    public boolean isAlreadyFinished() {
        return ladderGameResult.size() > 0;
    }

    public List<LadderLine> getLadderLine() {
        return ladder.getLadderLines();
    }
}
