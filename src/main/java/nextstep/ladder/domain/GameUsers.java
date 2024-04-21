package nextstep.ladder.domain;

import nextstep.ladder.GameUser;
import nextstep.ladder.LadderGame;
import nextstep.ladder.Position;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameUsers {
    private List<GameUser> gameUsers = new ArrayList<>();

    public GameUsers(List<GameUser> gameUsers) {
        this.gameUsers = gameUsers;
    }

    public GameUsers(UserNames userNames) {
        IntStream.range(0, userNames.getNames().size())
                .mapToObj(i -> new GameUser(userNames.getNames().get(i), new Position(i)))
                .forEach(gameUsers::add);
    }

    public void moveAllUsersOnLadderBoard(LadderBoard ladderBoard) {
        for (Line line : ladderBoard.getLadderBoard()) {
            for (GameUser gameUser : gameUsers) {
                gameUser.move(line);
            }
        }
    }

    public List<Integer> getResultPosition() {
        return gameUsers.stream().map(gameUser -> gameUser.getPosition()).collect(Collectors.toList());
    }

    public LadderGameResult makeResult(List<String> executionResult) {
        Map<String, String> result = new LinkedHashMap<>();

        IntStream.range(0, gameUsers.size())
                .forEach(i -> result.put(gameUsers.get(i).getUserName(), executionResult.get(gameUsers.get(i).getPosition())));

        return new LadderGameResult(result);
    }

}
