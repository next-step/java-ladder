package step4.domain;

import java.util.List;

public class WinningPrizes {

    private List<String> winningPrizes;

    public WinningPrizes(List<String> winningPrizes) {
        this.winningPrizes = winningPrizes;
    }

    public int size() {
        return this.winningPrizes.size();
    }

    public String get(int index) {
        return winningPrizes.get(index);
    }

}

