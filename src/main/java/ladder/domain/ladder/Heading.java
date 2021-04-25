package ladder.domain.ladder;

public enum Heading {

    RIGHT(1),
    LEFT(-1),
    PASS(0);

    final int changeValue;

    Heading(final int changeValue) {
        this.changeValue = changeValue;
    }

    public final int move(final int position) {
        return Math.addExact(position, changeValue);
    }

}
