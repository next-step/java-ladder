package ladder.domain;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultLadder implements Ladder {

    public static final int LADDER_LEVEL_CONVERSION_FACTOR = 2;

    private final List<LadderLevel> ladderLevels;
    private final LadderMemberAndResult memberAndResults;

    DefaultLadder(List<String> memberNames, List<String> results, List<LadderLevel> ladderLevels){
        this.memberAndResults = new LadderMemberAndResult(memberNames, results);
        this.ladderLevels = ladderLevels;
    }

    public DefaultLadder(List<String> memberNames, List<String> results, int height) {
        this(memberNames, results, generateLadderLevels(memberNames.size(), height));
    }

    static List<LadderLevel> generateLadderLevels(int memberCount, int height) {
        if (height < 1) throw new IllegalArgumentException("사다리 높이는 최소 1이상 입력되어야 합니다.");
        int width = memberCount * LADDER_LEVEL_CONVERSION_FACTOR - 1;
        return IntStream.range(0, height)
                .mapToObj(y -> LadderLevel.autoGenerate(width))
                .collect(Collectors.toList());
    }

    @Override
    public void print(PrintWriter writer) {
        writer.println(memberAndResults.toStringMembers());
        ladderLevels.forEach(writer::println);
        writer.println(memberAndResults.toStringResults());
        writer.flush();
    }

    @Override
    public LadderResult startFrom(LadderMember member) {
        int currPos = toLadderLevelPos(member.getPos());
        for( LadderLevel ladderLevel : ladderLevels ){
            currPos = ladderLevel.move(currPos);
        }
        return memberAndResults.getResult(toLadderResultPos(currPos));
    }

    @Override
    public LadderResult startFrom(String memberName) {
        return startFrom(memberAndResults.findMember(memberName));
    }

    @Override
    public Map<LadderMember, LadderResult> startAll() {
        Map<LadderMember, LadderResult> results = new HashMap<>();
        memberAndResults.forEachMember(member -> results.put(member, startFrom(member)));
        return results;
    }

    private int toLadderResultPos(int ladderLevelPos) {
        if( ladderLevelPos == 0 ) return 0;
        return ladderLevelPos / LADDER_LEVEL_CONVERSION_FACTOR;
    }

    private int toLadderLevelPos(int memberPos) {
        return memberPos * LADDER_LEVEL_CONVERSION_FACTOR;
    }

}
