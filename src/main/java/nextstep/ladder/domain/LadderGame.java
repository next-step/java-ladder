package nextstep.ladder.domain;

import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final Names names;
    private final Prizes prizes;

    public LadderGame(int height, List<String> names, List<String> prizes, LineStrategy lineStrategy) {
        if (names.size() != prizes.size()) {
            throw new IllegalArgumentException("사람 수와 결과 수는 같아야 합니다. (사람 수: " + names.size() + ", 결과 수: " + prizes.size() + ")");
        }
        this.ladder = new Ladder(height, names.size(), lineStrategy);
        this.names = new Names(names);
        this.prizes = new Prizes(prizes);
    }

    public String calculatePrize(String nameToShowResult) {
        int nameOrder = names.getOrderOf(nameToShowResult);
        int prizeOrder = ladder.execute(nameOrder);
        return prizes.get(prizeOrder);
    }

    public List<List<Boolean>> getLadder() {
        return ladder.getLines();
    }

    public List<String> getNames() {
        return names.getNames();
    }

    public List<String> getPrizes() {
        return prizes.getPrizes();
    }
}
