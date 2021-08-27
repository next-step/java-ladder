package nextstep.ladder.domain.winningPrize;

import nextstep.ladder.utils.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinningPrizes {

    private List<WinningPrize> winningPrizes;

    private WinningPrizes(List<WinningPrize> winningPrizes) {
        this.winningPrizes = winningPrizes;
    }

    public WinningPrizes from(List<WinningPrize> winningPrizes) {
        return new WinningPrizes(winningPrizes);
    }

    public WinningPrizes from(String winningPrizes) {
        return new WinningPrizes(
                StringUtils.splitWithComma(winningPrizes)
                        .stream().map(WinningPrize::new)
                        .collect(Collectors.toList()));
    }

    public List<WinningPrize> getWinningPrizes() {
        return Collections.unmodifiableList(winningPrizes);
    }
}
