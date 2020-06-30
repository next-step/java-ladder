package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderPrizes {

    private final List<LadderPrize> ladderPrizes;

    private LadderPrizes(Participants participants, List<LadderPrize> ladderPrizes) {
        validateSameCount(participants, ladderPrizes);
        this.ladderPrizes = Collections.unmodifiableList(ladderPrizes);
    }

    private LadderPrizes(List<LadderPrize> ladderPrizes) {
        this.ladderPrizes = ladderPrizes;
    }

    private void validateSameCount(Participants participants, List<LadderPrize> ladderPrizes) {
        if (participants.size() != ladderPrizes.size()) {
            throw new IllegalArgumentException("사다리 게임에 참여자의 수와 사다리 결과 수가 다릅니다.");
        }
    }

    public static LadderPrizes of(Participants participants, List<String> ladderPrizesText) {
        List<LadderPrize> ladderPrizes = ladderPrizesText.stream().map(LadderPrize::of).collect(Collectors.toList());
        return new LadderPrizes(participants, ladderPrizes);
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
