package ladder;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DefaultLadder implements Ladder {

    private List<LadderLevel> ladderLevels;
    private LadderMembers members;

    public DefaultLadder(List<String> memberNames, int height) {
        this.members = new LadderMembers(memberNames);
        if( height < 1 ) throw new IllegalArgumentException("사다리 높이는 최소 1이상 입력되어야 합니다.");

        initLadderLevels(getLadderWidth(this.members.size()), height);
    }

    private int getLadderWidth(int memberCount) {
        return memberCount * 2 - 1;
    }

    private void initLadderLevels(int width, int height) {
        ladderLevels = new ArrayList<>(height);
        IntStream.range(0, height)
                .forEach(y -> ladderLevels.add(LadderLevel.autoGenerate(width)));
    }

    @Override
    public void print(PrintWriter writer) {
        writer.println(members);
        ladderLevels.forEach(writer::println);
        writer.flush();
    }
}
