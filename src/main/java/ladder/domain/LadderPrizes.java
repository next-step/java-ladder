package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderPrizes {

    private final List<LadderPrize> ladderPrizes;

    private LadderPrizes(List<LadderPrize> ladderPrizes) {
        this.ladderPrizes = Collections.unmodifiableList(ladderPrizes);
    }

    public static LadderPrizes of(List<String> ladderPrizesText) {
        List<LadderPrize> ladderPrizes = ladderPrizesText.stream().map(LadderPrize::of).collect(Collectors.toList());
        return new LadderPrizes(ladderPrizes);
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
