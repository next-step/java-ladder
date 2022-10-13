package step1.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGameStarter {

    public static LadderGameResult start(Ladder ladder, UserNames userNames, List<Prize> prizes) {
        validateLadderGame(ladder, userNames, prizes);

        Lines lines = ladder.getLines();
        int width = lines.getWidth();
        int height = ladder.getHeight();

        Map<UserName, Prize> ladderGoalMap = new HashMap<>();
        for (int start = 0; start < width; start++) {
            Position startPosition = new Position(start);
            Position endPosition = getEndPosition(startPosition, lines, height);
            ladderGoalMap.put(userNames.getByIdx(start), prizes.get(endPosition.getPosition()));
        }

        return new LadderGameResult(ladderGoalMap);
    }

    private static Position getEndPosition(Position position, Lines lines, int height) {
        for (int h = 1; h <= height; h++) {
            position = position.moveDown(lines, h);
        }

        return position;
    }

    private static void validateLadderGame(Ladder ladder, UserNames userNames, List<Prize> prizes) {
        if (ladder.getLines().getWidth() != userNames.size() || userNames.size() != prizes.size()) {
            throw new IllegalArgumentException("사다리의 넓이와 userNames와 prizes의 개수가 모두 동일해야합니다.");
        }
    }
}
