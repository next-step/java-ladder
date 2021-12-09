package step4.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResult {
    private static final String NOT_FOUND_PARTICIPANT = "존재하지 않는 사용자입니다.";
    private static final int NOT_FOUND = -1;

    private final GameInfo gameInfo;
    private final Ladder ladder;

    private GameResult(GameInfo gameInfo, Ladder ladder) {
        this.gameInfo = gameInfo;
        this.ladder = ladder;
    }

    public static GameResult of(GameInfo gameInfo, Ladder ladder) {
        return new GameResult(gameInfo, ladder);
    }

    public String result(String name) {
        int participantIndex = gameInfo.participants().findIndexBy(name);
        if (participantIndex == NOT_FOUND) {
            return NOT_FOUND_PARTICIPANT;
        }
        Position position = cloneLadder().startBy(participantIndex);
        return gameInfo.rewards().findBy(position.position());
    }

    public String resultAll() {
        List<String> names = gameInfo.participants().participantNames();
        List<String> rewards = cloneLadder().startAll().stream()
                .map(position -> gameInfo.rewards().findBy(position.position()))
                .collect(Collectors.toList());
        return IntStream.range(0, names.size())
                .mapToObj((index) -> names.get(index) + " : " + rewards.get(index))
                .collect(Collectors.joining("\n"));
    }

    private Ladder cloneLadder() {
        try {
            return ladder.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return ladder;
    }
}
