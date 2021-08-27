package nextstep.ladder.domain.winningPrize;

import nextstep.ladder.utils.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinningPrizes {

    private static List<WinningPrize> winningPrizes;

    private WinningPrizes(List<WinningPrize> winningPrizes) {
        WinningPrizes.winningPrizes = winningPrizes;
    }

    public static List<WinningPrize> getWinningPrizes() {
        return Collections.unmodifiableList(winningPrizes);
    }

    public static WinningPrizes from(List<WinningPrize> winningPrizes) {
        return new WinningPrizes(winningPrizes);
    }

    public static WinningPrizes from(String winningPrizes) {
        return new WinningPrizes(
                StringUtils.splitWithComma(winningPrizes)
                        .stream().map(WinningPrize::new)
                        .collect(Collectors.toList()));
    }

    public static WinningPrize getWinningPrizeFromIndex(int index) {
        return winningPrizes.get(index);
    }
}
