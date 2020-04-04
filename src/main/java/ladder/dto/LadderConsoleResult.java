package ladder.dto;

import ladder.*;

import java.util.ArrayList;
import java.util.List;

public class LadderConsoleResult {

    private final List<Member> members;
    private final List<LadderLine> ladderLines;

    private LadderConsoleResult(final List<Member> members, final List<LadderLine> ladderLines) {
        this.members = new ArrayList<>(members);
        this.ladderLines = new ArrayList<>(ladderLines);
    }

    public static LadderConsoleResult newInstance(final LadderGame ladderGame) {
        return newInstance(ladderGame.getMembers(), ladderGame.getLadder());
    }

    public static LadderConsoleResult newInstance(final Members members, final Ladder ladder) {
        return new LadderConsoleResult(members.getMembers(), ladder.getLines());
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }
}
