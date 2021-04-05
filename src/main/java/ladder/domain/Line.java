package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Link> link;

    public Line(int numberOfPlayer, Linker linker) {
        link = new ArrayList<>();
        link.add(linker.link());
        for (int i = 1; i < numberOfPlayer-1; i++) {
            link.add(linker.link(link.get(i - 1)));
        }
    }

    public List<Link> link() {
        return link;
    }
}
