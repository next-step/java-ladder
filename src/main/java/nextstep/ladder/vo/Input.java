package nextstep.ladder.vo;

public class Input {
    private final String names;
    private final int number;

    public Input(final String names, final int number) {
        this.names = names;
        this.number = number;
    }

    public String getNames() {
        return names;
    }

    public int getNumber() {
        return number;
    }
}
