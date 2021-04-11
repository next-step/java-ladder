package nextstep;

import static nextstep.constant.Constant.RAND;

public class OnlineLadder extends Ladder {
    private final Lines lines;
    private final Players players;
    private final int height;

    public OnlineLadder(int maxVertical, int countOfPerson, String[] names) {
        this.height = maxVertical;
        this.lines = new Lines(maxVertical, countOfPerson);
        this.players = new Players(names);

    }

    public void lineMark(int targetVertical, int targetHorizon) {
        this.lines.mark(targetVertical, targetHorizon);
    }

    public void lineMark(int targetVertical) {
        this.lines.mark(targetVertical);
    }


    public String ladderString(int targetVertical) {
        return this.lines.lineString(targetVertical);
    }
}
