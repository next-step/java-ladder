package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;

public class RewardDirector {
    public static int searchReward(Ladder ladder, int startWidthPos) {
        int nowHeight = 0;
        int maxHeight = ladder.getLines().size();
        int nowWidth = startWidthPos;

        while(maxHeight > nowHeight) {
            Line line = ladder.getLines().get(nowHeight);

            nowWidth = line.move(nowWidth);

            nowHeight += 1;
        }

        return nowWidth;
    }

}
