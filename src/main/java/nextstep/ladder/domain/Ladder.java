package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    public static int MAX_PLAYER_NAME_LENGTH = 5;
    private final List<String> playerNames;
    private final List<Line> lines = new ArrayList<>();

    public Ladder(List<String> playerNames, int height, LineStrategy lineStrategy) {
        validateNameLen(playerNames);
        this.playerNames = playerNames;

        for (int i = 0; i < height; i++) {
            lines.add(new Line(playerNames.size(), lineStrategy));
        }
    }

    private static void validateNameLen(List<String> playerNames) {
        for (String player : playerNames) {
            if (player.length() > MAX_PLAYER_NAME_LENGTH) {
                throw new IllegalArgumentException("최대 5자까지 입력가능합니다.");
            }
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }
}
