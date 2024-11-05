package nextstep.ladder;

import java.util.Random;

public class Point {

    private static final Random RANDOM = new Random();
    private boolean left;
    private boolean right;

    public Point(boolean prev, boolean isLast) {
        generate(prev, isLast);
    }

    private void generate(boolean prev, boolean isLast) {
        this.left = prev;
        this.right = isLast ? false : generateRandomRightPoint(prev);
    }

    private boolean generateRandomRightPoint(boolean prev) {
        return prev ? false : RANDOM.nextBoolean();
    }

    public boolean getRight() {
        return right;
    }

    public String getLineSymbol(String trueSymbol, String falseSymbol) {
        return right ? trueSymbol : falseSymbol;
    }
}
