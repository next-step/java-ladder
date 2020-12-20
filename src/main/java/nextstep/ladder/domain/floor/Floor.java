package nextstep.ladder.domain.floor;

import java.util.List;

public class Floor {

    private final List<Boolean> links;

    public Floor(List<Boolean> links) {
        this.links = links;
    }

    public boolean getLinked(int x) {
        validateX(x);
        return links.get(x);
    }

    public int getMaxLinks() {
        return links.size();
    }

    private void validateX(int x) {
        if (x > links.size()) {
            throw new IllegalArgumentException("x 값은 " + links.size() + "를 넘을 수 없습니다");
        }
    }
}
