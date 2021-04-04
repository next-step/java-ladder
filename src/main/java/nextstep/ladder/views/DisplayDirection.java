package nextstep.ladder.views;

public enum DisplayDirection {
    DOWN("|     "),
    RIGHT("|-----"),
    LEFT("|     ");

    public String displayChar;

    DisplayDirection(String displayChar) {
        this.displayChar = displayChar;
    }
}
