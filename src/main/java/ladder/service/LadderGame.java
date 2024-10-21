package ladder.service;

import ladder.domain.CreateStrategy;
import ladder.domain.LadderResult;
import ladder.domain.Line;
import ladder.domain.Member;
import ladder.domain.Reword;

import java.util.LinkedHashMap;
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

    public LadderResult playLadders(List<Line> ladders, List<Member> members, List<Reword> rewords) {
        if (members.size() != rewords.size()) {
            throw new IllegalStateException("사다리 게임을 진행할 수 없습니다.");
        }
        List<Integer> point = getResultPoints(ladders, members.size());
        return new LadderResult(getResultMap(members, rewords, point));
    }

    private static List<Integer> getResultPoints(List<Line> ladders, int memberCount) {
        List<Integer> point = IntStream.range(0, memberCount)
                .boxed()
                .collect(Collectors.toList());
        for (Line ladder : ladders) {
            point = ladder.moveResult(point);
        }
        return point;
    }

    private static LinkedHashMap<Member, Reword> getResultMap(List<Member> members, List<Reword> rewords, List<Integer> point) {
        LinkedHashMap<Member, Reword> map = new LinkedHashMap<>();
        IntStream.range(0, members.size())
                .forEach(index -> map.put(members.get(index), rewords.get(point.get(index))));
        return map;
    }

}
