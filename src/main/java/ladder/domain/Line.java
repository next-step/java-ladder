package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Link> links;

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

    private Link previousLink(int currentIndex) {
        return links.get(currentIndex - 1);
    }
}
