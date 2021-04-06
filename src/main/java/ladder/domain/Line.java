package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Link> links;

    public Line(int numberOfPlayer, Linker linker) {
        links = new ArrayList<>();
        links.add(linker.link());
        for (int i = 1; i < numberOfPlayer - 1; i++) {
            links.add(linker.link(links.get(i - 1)));
        }
    }

    public List<Link> links() {
        return links;
    }
}
