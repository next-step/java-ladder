package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderPrizes {

    private final List<LadderPrize> ladderPrizes;

    private LadderPrizes(List<LadderPrize> ladderPrizes, Ladder ladder) {
        validateSameCount(ladderPrizes, ladder);
        this.ladderPrizes = Collections.unmodifiableList(ladderPrizes);
    }

    private LadderPrizes(List<LadderPrize> ladderPrizes) {
        this.ladderPrizes =  Collections.unmodifiableList(ladderPrizes);
    }

    public static LadderPrizes of(List<LadderPrize> ladderPrizes, Ladder ladder) {
        return new LadderPrizes(ladderPrizes, ladder);
    }

    private void validateSameCount(List<LadderPrize>  ladderPrizes, Ladder ladder) {
        if(!ladder.equalStartPositionCount(ladderPrizes.size())) {
            throw new IllegalArgumentException("입력한 사다리 결과 수와 사다리의 startPostion 수가 다릅니다.");
        }
    }

    public static LadderPrizes convert(List<Integer> resultAfterPlay, LadderPrizes fromLadderPrizes) {
        List<LadderPrize> ladderPrizesConverted = resultAfterPlay.stream()
                .map(fromLadderPrizes::get)
                .collect(Collectors.toList());
        return new LadderPrizes(ladderPrizesConverted);
    }

    public LadderPrize get(int index) {
        return ladderPrizes.get(index);
    }

    public int size() {
        return ladderPrizes.size();
    }
}
