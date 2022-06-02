package ladder.domain;

import ladder.strategy.LineStrategy;

import java.util.List;

public class LadderFactory {
    // 사다리를 생성하면서 아예 게임결과까지 한꺼번에 저장하도록 수정해보자
    public static Ladder create(int heightOfLadder, int countOfParticipants, LineStrategy lineStrategy) {
        List<Line> lines = LineFactory.createLines(heightOfLadder, countOfParticipants, lineStrategy);
        return Ladder.from(lines);
    }
}