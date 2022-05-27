package ladder.domain;

public class LadderGame {

    private final ElementGroup elementGroup;
    private final Ladder ladder;

    public LadderGame(Elements playerElements, Elements resultElements, Height height) {
        this(new ElementGroup(playerElements, resultElements), new Ladder(height, playerElements));
    }

    public LadderGame(ElementGroup elementGroup, Height height) {
        this(elementGroup, new Ladder(height, elementGroup.playerElements()));
    }

    public LadderGame(ElementGroup elementGroup, Ladder ladder) {
        this.elementGroup = elementGroup;
        this.ladder = ladder;
    }

    public Ladder ladder() {
        return ladder;
    }

    public Elements playerElements() {
        return elementGroup.playerElements();
    }

    public Elements resultElements() {
        return elementGroup.resultElements();
    }

    public int maxNameSize() {
        return elementGroup.maxNameSize();
    }
}
