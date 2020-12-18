package nextstep.ladder.domain;

import java.util.List;

public class Links {

    private final boolean[][] links;
    private final int boundX;
    private final int boundY;

    public Links(int x, int y) {
        links = new boolean[x][y];
        boundX = x;
        boundY = y;
    }

    public void markOn(int x, int y) {
        validateBound(x, y);
        links[x][y] = true;
    }

    public void markOff(int x, int y) {
        validateBound(x, y);
        links[x][y] = false;
    }

    public int getBoundX() {
        return boundX;
    }

    public int getBoundY() {
        return boundY;
    }

    public boolean getMark(int x, int y) {
        validateBound(x, y);
        return links[x][y];
    }

    private void validateBound(int x, int y) {
        if (x > boundX) {
            throw new IllegalArgumentException("x 값은 " + x + "를 넘을 수 없습니다");
        }
        if (y > boundY) {
            throw new IllegalArgumentException("y 값은 " + y + "를 넘을 수 없습니다");
        }
    }

}
