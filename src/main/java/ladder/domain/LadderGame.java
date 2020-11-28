package ladder.domain;

import ladder.dto.LadderResultDTO;

public class LadderGame {
    private final Users users;
    private final Ladder ladder;

    private LadderGame(final Users users, final Ladder ladder) {
        this.users = users;
        this.ladder = ladder;
    }

    public static LadderGame of(final String usersExpression, final int ladderHeight) {
        final Users users = UsersGenerator.generate(usersExpression);
        final Ladder ladder = Ladder.of(users.size(), ladderHeight);
        return new LadderGame(users, ladder);
    }

    public LadderResultDTO getLadderViewResult() {
        return new LadderResultDTO(users.getNames(), ladder.getLadderLines());
    }
}
