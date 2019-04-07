package domain.ladder;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Pair> pairs;

    public Line() {
        this.pairs = new ArrayList<>();
    }

    public Line generate(int userCount) {
        Pair pair = first();
        pairs.add(pair);

        for (int i = 1; i < userCount - 1; i++) {
            pair = new Pair().make(pair.isRight());
            pairs.add(pair);
        }
        pairs.add(last(pair.isRight()));

        return this;
    }

    private Pair first() {
        return new Pair().make(Boolean.FALSE);
    }

    private Pair last(boolean left) {
        return new Pair(left, Boolean.FALSE);
    }

    public int size() {
        return pairs.size();
    }

    public String toString(int margin) {
        String result = "";
        for (Pair pair : pairs) {
            if (pair.isLeft()) {
                result += StringUtils.repeat("-", margin);
                result += "|";
                continue;
            }

            result += StringUtils.repeat(" ", margin);
            result += "|";
        }
        return result;
    }
}
