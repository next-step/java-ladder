package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ElementGroup {

    private final Elements playerElements;
    private final Elements resultElements;

    public ElementGroup(Elements playerElements, Elements resultElements) {
        if (playerElements == null || resultElements == null) {
            throw new IllegalArgumentException();
        }
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

    public Result result(Name name) {
        Element player = playerElements.value(name);
        return new Result(player.name(), resultElements.value(player.position()));
    }

    public List<Result> resultAll() {
        return playerElements.toList()
                .stream()
                .map(Element::name)
                .map(name -> result(name))
                .collect(Collectors.toList());
    }
}
