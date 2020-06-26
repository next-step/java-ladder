package nextstep.ladder.domain;

import java.util.List;

public class Line extends LineGenerating {

    private static final String INVALID_LINE_LENGTH = "Line 길이는 2이상으로 생성 할 수 있습니다.";
    private List<Boolean> ladders;

    public Line(int length, GenerableStrategy generableStrategy) {
        super(generableStrategy);
        validateLength(length);
        ladders = generate(length);
    }

    private void validateLength(int length) {
        if (length < 1) {
            throw new IllegalArgumentException(INVALID_LINE_LENGTH);
        }
    }


    public int getLadderLength() {
        return ladders.size();
    }

    public List<Boolean> getLine() {
        return ladders;
    }

    @Override
    public String toString() {
        return "Line{" +
            "ladders=" + ladders +
            '}';
    }
}
