package nextstep.ladder.dto;

import java.util.List;

public class LadderElementsDto {

    private final List<String> elements;

    public LadderElementsDto(final List<String> elements) {
        this.elements = elements;
    }

    public List<String> getElements() {
        return elements;
    }

    public String getElement(final int position) {
        return elements.get(position);
    }

}
