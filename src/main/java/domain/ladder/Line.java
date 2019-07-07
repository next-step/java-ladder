package domain.ladder;

import domain.bridge.BridgeGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private static final int SINGLE = 1;

    private List<Pair> pairs;
    private BridgeGenerator bridgeGenerator;

    public Line(BridgeGenerator bridgeGenerator) {
        this.pairs = new ArrayList<>();
        this.bridgeGenerator = bridgeGenerator;
    }

    public Line generate(int userCount) {
        if (userCount == SINGLE) {
            return generateSinglePair();
        }

        boolean isRight = addFirst();
        isRight = addMiddle(userCount, isRight);
        addLast(isRight);
        return this;
    }

    private Line generateSinglePair() {
        pairs.add(Pair.single());
        return this;
    }

    private boolean addFirst() {
        Pair pair = Pair.first(bridgeGenerator.generate(Boolean.FALSE));
        pairs.add(pair);
        return pair.isRight();
    }

    private void addLast(boolean left) {
        Pair pair = Pair.last(left);
        pairs.add(pair);
    }

    private boolean addMiddle(int userCount, boolean left) {
        for (int i = 0; i < userCount - 2; i++) {
            Pair pair = Pair.middle(left, bridgeGenerator.generate(left));
            pairs.add(pair);
            left = pair.isRight();
        }
        return left;
    }

    public int size() {
        return pairs.size();
    }

    public List<Pair> getPairs() {
        return Collections.unmodifiableList(pairs);
    }

    public int next(int current) {
        return pairs.get(current).next(current);
    }
}
