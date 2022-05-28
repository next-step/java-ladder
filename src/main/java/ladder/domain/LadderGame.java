package ladder.domain;

import java.util.List;

public class LadderGame {

    public static final String ALL_RESULT = "all";

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

    public void start() {
        ladder.start(elementGroup.playerElements());
    }

    public List<Result> results(String value) {
        if (value.equals(ALL_RESULT)) {
            return elementGroup.resultAll();
        }
        return List.of(elementGroup.result(new Name(value)));
    }
}
