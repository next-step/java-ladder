package nextstep.ladder.domain.floor;

import java.util.List;
import java.util.Optional;

public class Floor {

    private final List<Link> links;

    public Floor(int sizeOfPosition, List<Link> links) {
        validatePositionAndLinks(sizeOfPosition, links);
        this.links = links;
    }

    public Optional<Link> getLeftLinkOf(Position position) {
        if (position.isMostLeft()) {
            return Optional.empty();
        }
        return Optional.of(links.get(position.getCurrentPosition() - 1));
    }

    public Optional<Link> getRightLinkOf(Position position) {
        if (position.isMostRight()) {
            return Optional.empty();
        }
        return Optional.of(links.get(position.getCurrentPosition()));
    }

    public int getSizeOfPositions() {
        return links.size() + 1;
    }

    public void followFrom(Position position) {
        Link left = getLeftLinkOf(position).orElse(Link.UNLINKED);
        if (left == Link.LINKED) {
            position.moveLeft();
            return;
        }
        Link right = getRightLinkOf(position).orElse(Link.UNLINKED);
        if (right == Link.LINKED) {
            position.moveRight();
        }
    }

    private void validatePositionAndLinks(int sizeOfPosition, List<Link> links) {
        if (links.size() + 1 != sizeOfPosition) {
            throw new IllegalArgumentException("link의 수가 position 수와 맞지 않습니다");
        }
    }
}
