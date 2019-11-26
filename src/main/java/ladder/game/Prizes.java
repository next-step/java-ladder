package ladder.game;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Prizes {
    private final List<Prize> prizes;

    public Prizes(List<String> inputResults) {
        this.prizes = inputResults.stream().map(Prize::new).collect(toList());
    }

    public String getPrize(int index) {
        return prizes.get(index).toString();
    }

    public int getSize() {
        return prizes.size();
    }
}
