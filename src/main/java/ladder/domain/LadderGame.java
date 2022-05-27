package ladder.domain;

public class LadderGame {

    // TODO: elements 묶는 elementGroup 클래스 생성?
    private final Elements elements;
    private final Elements resultElements;
    private final Ladder ladder;

    public LadderGame(Elements elements, Elements resultElements, Height height) {
        this.elements = elements;
        this.resultElements = resultElements;
        this.ladder = new Ladder(height, elements);
    }

    public Ladder ladder() {
        return ladder;
    }

    public Elements people() {
        return elements;
    }

    public Elements resultElements() {
        return resultElements;
    }

    public int maxNameSize() {
        int elementsMaxNameSize = elements.maxNameSize();
        int resultElementsMaxNameSize = resultElements.maxNameSize();
        return Integer.max(elementsMaxNameSize, resultElementsMaxNameSize);
    }
}
