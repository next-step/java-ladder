package ladder.domain;

import ladder.dto.LadderResultDTO;

public class LadderGame {
    private final Users users;
    private final TotalLadderLine totalLadderLine;

    private LadderGame(final Users users, final TotalLadderLine totalLadderLine) {
        this.users = users;
        this.totalLadderLine = totalLadderLine;
    }

    public static LadderGame of(final String usersExpression, final int ladderHeight) {
        final Users users = UsersGenerator.generate(usersExpression);
        final TotalLadderLine totalLadderLine = TotalLadderLine.of(users.size(), ladderHeight);
        return new LadderGame(users, totalLadderLine);
    }

    public LadderResultDTO getLadderViewResult() {
        return new LadderResultDTO(users.getNames(), totalLadderLine.getLadderLines());
    }
}
