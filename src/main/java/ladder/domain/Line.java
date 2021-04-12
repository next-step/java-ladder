package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Link> links;

    public Line(List<Link> links) {
        this.links = links;
    }

    public Line(int numberOfPlayer, Linker linker) {
        links = new ArrayList<>();

        links.add(linker.link());
        for (int linkIndex = 1; linkIndex < numberOfPlayer - 1; linkIndex++) {
            links.add(linker.link(previousLink(linkIndex)));
        }
    }

    public List<Link> links() {
        return links;
    }

    private Link previousLink(int point) {
        if (point <= 0) {
            return Link.OPEN;
        }

        return links.get(point - 1);
    }

    private Link currentLink(int point) {
        if (point >= links.size()) {
            return Link.OPEN;
        }
        return links.get(point);
    }

    public int endPoint(int startPoint) {
        if (currentLink(startPoint) == Link.CLOSE)
            return startPoint + 1;
        if (previousLink(startPoint) == Link.CLOSE)
            return startPoint - 1;
        return startPoint;
    }
}
