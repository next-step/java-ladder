package nextstep.ladder.entity.ladder;

public class LadderLine {

    private final int value;

    public LadderLine(int value) {
        this.value = value;
    }

    public boolean more(int count) {
        return count <= value;
    }

}
