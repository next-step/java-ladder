package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderGamePrizes {

    private final List<LadderGamePrize> ladderGamePrizes;

    private LadderGamePrizes(String[] ladderGamePrizes) {
        Objects.requireNonNull(ladderGamePrizes, "게임결과보상목록 입력은 필수입니다.");
        this.ladderGamePrizes = Arrays.stream(ladderGamePrizes)
            .map(LadderGamePrize::new)
            .collect(Collectors.toUnmodifiableList());
    }

    public static LadderGamePrizes from(String[] ladderGamePrizes) {
        return new LadderGamePrizes(ladderGamePrizes);
    }

    public List<LadderGamePrize> getLadderGamePrizes() {
        return ladderGamePrizes;
    }
}
