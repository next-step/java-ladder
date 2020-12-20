package nextstep.ladder.domain.floor;

import java.util.List;
import java.util.Optional;

public class Floor {

    private final List<Link> links;

    public Floor(int sizeOfPosition, List<Link> links) {
        validatePositionAndLinks(sizeOfPosition, links);
        this.links = links;
    }

    public Optional<Link> getLeftLinkOf(int position) {
        validatePosition(position);
        if (position <= 0) {
            return Optional.empty();
        }
        return Optional.of(links.get(position - 1));
    }

    public Optional<Link> getRightLinkOf(int position) {
        validatePosition(position);
        if (position >= links.size()) {
            return Optional.empty();
        }
        return Optional.of(links.get(position));
    }

    public int getSizeOfPositions() {
        return links.size() + 1;
    }

    public int followFrom(int position) {
        validatePosition(position);
        Link left = getLeftLinkOf(position).orElse(Link.UNLINKED);
        if (left == Link.LINKED) {
            return position - 1;
        }
        Link right = getRightLinkOf(position).orElse(Link.UNLINKED);
        if (right == Link.LINKED) {
            return position + 1;
        }
        return position;
    }

    private void validatePositionAndLinks(int sizeOfPosition, List<Link> links) {
        if (links.size() + 1 != sizeOfPosition) {
            throw new IllegalArgumentException("link의 수가 position 수와 맞지 않습니다");
        }
    }

    private void validatePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("position 의 값은 0보다 작을 수 없습니다");
        }
        if (position > links.size()) {
            throw new IllegalArgumentException("position 의 값은 " + links.size() + "보다 클 수 없습니다");
        }
    }
}
