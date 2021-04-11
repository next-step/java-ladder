package nextstep.model;

public class OnlineLadder extends Ladder {
    private final Lines lines;
    private final Players players;
    private final int height;

    public OnlineLadder(int maxVertical, int countOfPerson, String[] names) {
        this.height = maxVertical;
        this.lines = new Lines(maxVertical, countOfPerson);
        this.players = new Players(names);
        this.lineMarkAll();
    }

    public void lineMark(int targetVertical, int targetHorizon) {
        this.lines.mark(targetVertical, targetHorizon);
    }

    public void lineMark(int targetVertical) {
        this.lines.mark(targetVertical);
    }

    public void lineMarkAll() {
        for (int i = 0; i < this.height; i++) {
            this.lines.mark(i);
        }
    }

    public String ladderString(int targetVertical) {
        return this.lines.lineString(targetVertical);
    }

    public String playersString() {
        return this.players.names();
    }
}
