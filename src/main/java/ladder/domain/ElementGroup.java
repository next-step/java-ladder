package ladder.domain;

public class ElementGroup {

    private final Elements playerElements;
    private final Elements resultElements;

    public ElementGroup(Elements playerElements, Elements resultElements) {
        this.playerElements = playerElements;
        this.resultElements = resultElements;
    }

    public int maxNameSize() {
        int elementsMaxNameSize = playerElements.maxNameSize();
        int resultElementsMaxNameSize = resultElements.maxNameSize();
        return Integer.max(elementsMaxNameSize, resultElementsMaxNameSize);
    }

    public Elements playerElements() {
        return playerElements;
    }

    public Elements resultElements() {
        return resultElements;
    }

}
