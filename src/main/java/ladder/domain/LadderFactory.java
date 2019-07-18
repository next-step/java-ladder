package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderFactory {
    private final List<LadderLine> ladder;

    public LadderFactory(int maxHeight, int sizeOfUserGroup) {
        if(maxHeight <= 0){
            throw new IllegalArgumentException("최대 사다리 높이 값이 잘못 입력되었습니다. 다시 프로그램을 실행해주세요.");
        }
        ladder = new ArrayList<>();

        for (int i = 0; i < maxHeight; ++i) {
            ladder.add(LadderLine.init(sizeOfUserGroup));
        }
    }

    public List<LadderLine> getLadder() {
        return ladder;
    }
}
