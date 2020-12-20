package nextstep.ladder.domain.floor;

import java.util.List;

public class Floor {

    private final List<Link> links;

    public Floor(List<Link> links) {
        this.links = links;
    }

    public Link getLink(int position) {
        validatePosition(position);
        return links.get(position);
    }

    public int getSizeOfLinks() {
        return links.size();
    }

    private void validatePosition(int position) {
        if (position > links.size()) {
            throw new IllegalArgumentException("위치 값은 " + links.size() + "를 넘을 수 없습니다");
        }
    }
}
