package nextstep.ladder.domain.floor;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private final List<Link> links;

    public Floor(int sizeOfPosition, List<Link> links) {
        this.links = new ArrayList<>();
        this.links.add(Link.UNLINKED);
        this.links.addAll(links);
        this.links.add(Link.UNLINKED);
        validatePositionAndLinks(sizeOfPosition);
    }

    public void followFrom(Position position) {
        Link left = getLeftLinkOf(position);
        if (left == Link.LINKED) {
            position.moveLeft();
            return;
        }
        Link right = getRightLinkOf(position);
        if (right == Link.LINKED) {
            position.moveRight();
        }
    }

    public List<Link> getLinks() {
        return links;
    }

    private Link getLeftLinkOf(Position position) {
        return links.get(position.getCurrentPosition());
    }

    private Link getRightLinkOf(Position position) {
        return links.get(position.getCurrentPosition() + 1);
    }

    private void validatePositionAndLinks(int sizeOfPosition) {
        if (links.size() != sizeOfPosition + 1) {
            throw new IllegalArgumentException("입력된 link의 수가 position 수와 맞지 않습니다");
        }
        if (links.get(0) != Link.UNLINKED) {
            throw new IllegalArgumentException("맨 처음 link 는 UNLINK 이어야 합니다");
        }
        if (links.get(sizeOfPosition) != Link.UNLINKED) {
            throw new IllegalArgumentException("맨 마지막 link 는 UNLINK 이어야 합니다");
        }
    }
}
