package ladder.domain;

public class Ladder {

    private Lines lines;

    public Ladder(Lines lines) {
        this.lines = lines;
    }

    public String draw() {
        return lines.drawLine();
    }

}
