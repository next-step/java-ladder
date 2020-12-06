package ladder.domain.model;

import java.util.stream.Collectors;
import ladder.domain.Position;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.result.ResultPrize;
import ladder.domain.user.User;
import ladder.domain.user.Users;

public class LadderGameInfo {

    private static final String RESULT_ALL_FORMAT = "%s : %s";

    private final Users users;
    private final ResultPrize resultPrize;
    private final LadderHeight ladderHeight;

    public LadderGameInfo(Users users, ResultPrize resultPrize, LadderHeight ladderHeight) {
        this.users = users;
        this.resultPrize = resultPrize;
        this.ladderHeight = ladderHeight;
    }

    public Users getUsers() {
        return users;
    }

    public ResultPrize getResultPrize() {
        return resultPrize;
    }

    public LadderHeight getLadderHeight() {
        return ladderHeight;
    }

    public Position getResultPositionByName(String name, Ladder ladder) {
        User namedUser = users.getUserByName(name);
        return ladder.playGame(namedUser);
    }

    public String getAllResultPosition(Ladder ladder) {
        return users
            .getUsers()
            .stream()
            .map(participant -> {
                Position resultCoordinate = ladder.playGame(participant);
                return String.format(RESULT_ALL_FORMAT, participant.getName(), resultPrize.getResultByResultPosition(resultCoordinate));
            })
            .collect(Collectors.joining(System.lineSeparator()));
    }
}
