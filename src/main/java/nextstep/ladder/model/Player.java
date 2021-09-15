package nextstep.ladder.model;

public class Player {
    private int currentWidth;

    public int getCurrentWidth() {
        return currentWidth;
    }

    public Player(int startWidth) {
        this.currentWidth = startWidth;
    }

    public void goLeft() {
        currentWidth -= 1;
    }

    public void goRight() {
        currentWidth += 1;
    }
}
