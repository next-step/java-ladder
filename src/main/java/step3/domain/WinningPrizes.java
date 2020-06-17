package step3.domain;

import java.util.List;

public class WinningPrizes {

    List<String> winningPrizes;

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

