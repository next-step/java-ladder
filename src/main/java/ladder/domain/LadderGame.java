package ladder.domain;

public class LadderGame {

    private final Elements elements;
    private final Ladder ladder;

    public LadderGame(Elements elements, Height height) {
        this.elements = elements;
        this.ladder = new Ladder(height, elements);
    }

    public Ladder ladder() {
        return ladder;
    }

    public Elements people() {
        return elements;
    }
}
