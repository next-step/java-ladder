package ladder.service;

import ladder.domain.CreateStrategy;
import ladder.domain.Line;
import ladder.domain.Member;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private static LadderGame INSTANCE = null;

    private LadderGame() {
    }

    public static LadderGame getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LadderGame();
        }
        return INSTANCE;
    }

    public List<Line> createLadders(List<Member> members, int height, CreateStrategy createStrategy) {
        return IntStream.range(0, height)
                .mapToObj(num -> new Line(members.size(), createStrategy))
                .collect(Collectors.toList());
    }
}
