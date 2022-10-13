package step4.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGameStarter {

    public static LadderGameResult start(Ladder ladder, UserNames userNames, List<Prize> prizes) {
        if (ladder.getLines().getWidth() != userNames.size() || userNames.size() != prizes.size()) {
            throw new IllegalArgumentException("사다리의 넓이와 userNames, prizes의 개수는 모두 동일해야합니다.");
        }

        Lines lines = ladder.getLines();
        int width = lines.getWidth();
        int height = ladder.getHeight();
        Map<UserName, Prize> ladderGoalMap = new HashMap<>();
        for (int start = 0; start < width; start++) {
            UserName userName = userNames.getUserNames().get(start);
            Position endPosition = getEndPosition(new Position(start), lines, height);
            Prize prize = prizes.get(endPosition.getPosition());
            ladderGoalMap.put(userName, prize);
        }

        return new LadderGameResult(ladderGoalMap);
    }

    private static Position getEndPosition(Position position, Lines lines, int height) {
        for (int h = 1; h <= height; h++) {
            position = position.moveDown(lines, h);
        }
        return position;
    }
}
