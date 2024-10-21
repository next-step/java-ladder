package ladder.service;

import ladder.domain.Line;
import ladder.domain.Member;
import ladder.domain.RandomStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private LadderGame() {
    }

    private static LadderGame INSTANCE = null;

    public static LadderGame getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LadderGame();
        }
        return INSTANCE;
    }

    public List<Line> createLadders(List<Member> members, int height) {
        return IntStream.range(0, height)
                .mapToObj(num -> new Line(members.size(), RandomStrategy.getInstance()))
                .collect(Collectors.toList());
    }
}
