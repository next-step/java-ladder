package domain.ladder;

import util.BridgeGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Pair> pairs;

    public Line() {
        this.pairs = new ArrayList<>();
    }

    public Line generate(int userCount) {
        boolean isRight = addFirst();
        isRight = addMiddle(userCount, isRight);
        addLast(isRight);
        return this;
    }

    private boolean addFirst() {
        Pair pair = Pair.first(BridgeGenerator.generate(Boolean.FALSE));
        pairs.add(pair);
        return pair.isRight();
    }

    private void addLast(boolean left) {
        Pair pair = Pair.last(left);
        pairs.add(pair);
    }

    private boolean addMiddle(int userCount, boolean left) {
        for (int i = 0; i < userCount - 2; i++) {
            Pair pair = Pair.middle(left, BridgeGenerator.generate(left));
            pairs.add(pair);
            left = pair.isRight();
        }
        return left;
    }

    public int size() {
        return pairs.size();
    }

    public List<Pair> getPairs() {
        return pairs;
    }
}
