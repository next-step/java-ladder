package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderList {

    private final List<Ladder> ladderList;

    public LadderList(List<Ladder> ladderList) {
        this.ladderList = ladderList;
    }

    public static LadderList of(String[] prizeListInOrder) {
        List<Ladder> list = IntStream.range(0, prizeListInOrder.length)
                .mapToObj(i -> new Ladder(i, prizeListInOrder[i]))
                .collect(Collectors.toList());
        return new LadderList(list);
    }

    public Prize prize(LadderNumber ladderNumber) {
        return ladderList.stream()
                .filter(ladder -> ladder.isMatch(ladderNumber))
                .findFirst()
                .map(Ladder::prize)
                .orElseThrow(() -> new IllegalArgumentException("게임이 잘 못 되었습니다."));
    }

    public List<Ladder> ladderList() {
        return ladderList;
    }
}
