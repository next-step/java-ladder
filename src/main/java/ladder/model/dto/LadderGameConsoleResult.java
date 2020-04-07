package ladder.model.dto;

import ladder.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderGameConsoleResult {

    private final List<Member> members;
    private final List<LadderLine> ladderLines;

    //Q1. unmodifiableList를 생성자에서 아예 쓰고 getter에서는 deepcopy만..?
    private LadderGameConsoleResult(final List<Member> members, final List<LadderLine> ladderLines) {
        this.members = Collections.unmodifiableList(members);
        this.ladderLines = Collections.unmodifiableList(ladderLines);
    }

    public static LadderGameConsoleResult newInstance(final LadderGame ladderGame) {
        return newInstance(ladderGame.getMembers(), ladderGame.getLadder());
    }

    public static LadderGameConsoleResult newInstance(final Members members, final Ladder ladder) {
        return new LadderGameConsoleResult(members.getMembers(), ladder.getLines());
    }

    public List<Member> getMembers() {
        return new ArrayList<>(members);
    }

    public List<LadderLine> getLadderLines() {
        return new ArrayList<>(ladderLines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderGameConsoleResult)) return false;
        LadderGameConsoleResult that = (LadderGameConsoleResult) o;
        return Objects.equals(getMembers(), that.getMembers()) &&
                Objects.equals(getLadderLines(), that.getLadderLines());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMembers(), getLadderLines());
    }
}
