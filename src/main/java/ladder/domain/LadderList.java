package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderList {

    private final List<Ladder> ladderList;

    public LadderList() {
        ladderList = new ArrayList<>();
    }

    public LadderList(List<Ladder> ladderList) {
        this.ladderList = ladderList;
    }

    public Prize prize(LadderNumber ladderNumber){
        return ladderList.stream()
                .filter(ladder -> ladder.isMatch(ladderNumber))
                .findFirst()
                .map(Ladder::prize)
                .orElseThrow(() -> new IllegalArgumentException("게임이 잘 못 되었습니다."));
    }
}
