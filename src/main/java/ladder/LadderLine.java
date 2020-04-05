package ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderLine {
    private final List<LadderLink> ladderLinks;

    public static LadderLine of(int userCount) {
        return new LadderLine(Stream.iterate(LadderLink.DIS_CONNECT, LadderLink::of)
                .limit(userCount)
                .collect(Collectors.toList()));
    }

    public LadderLine(List<LadderLink> ladderLinks) {
        this.ladderLinks = ladderLinks;
    }

    public int getLinkCount() {
        return ladderLinks.size();
    }
}
