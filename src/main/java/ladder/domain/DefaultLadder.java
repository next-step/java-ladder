package ladder.domain;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultLadder implements Ladder {

    private List<LadderLevel> ladderLevels;
    private LadderMembers members;
    private LadderResults results;

    public DefaultLadder(List<String> memberNames, List<String> results, int height, List<LadderLevel> ladderLevels){
        if( memberNames.size() != results.size() ) throw new IllegalArgumentException("참여자와 결과의 개수는 동일해야 합니다");
        if (height < 1) throw new IllegalArgumentException("사다리 높이는 최소 1이상 입력되어야 합니다.");

        this.members = new LadderMembers(memberNames);
        this.results = new LadderResults(results);
        this.ladderLevels = ladderLevels;
    }

    public DefaultLadder(List<String> memberNames, List<String> results, int height) {
        this(memberNames, results, height, generateLadderLevels(memberNames.size(), height));
    }

    static List<LadderLevel> generateLadderLevels(int memberCount, int height) {
        int width = memberCount * 2 - 1;
        return IntStream.range(0, height)
                .mapToObj(y -> LadderLevel.autoGenerate(width))
                .collect(Collectors.toList());
    }

    @Override
    public void print(PrintWriter writer) {
        writer.println(members);
        ladderLevels.forEach(writer::println);
        writer.println(results);
        writer.flush();
    }

    @Override
    public String startFrom(String memberName) {
        int memberPos = members.getPosition(memberName);
        int currPos = toLadderLevelPos(memberPos);
        for( LadderLevel ladderLevel : ladderLevels ){
            currPos = ladderLevel.move(currPos);
        }
        return results.get(toLadderResultPos(currPos));
    }

    @Override
    public Map<String, String> startAll() {
        Map<String, String> results = new HashMap<>();
        members.forEach(name -> results.put(name, startFrom(name)));
        return results;
    }

    private int toLadderResultPos(int ladderLevelPos) {
        if( ladderLevelPos == 0 ) return 0;
        return ladderLevelPos / 2;
    }

    private int toLadderLevelPos(int memberPos) {
        return memberPos * 2;
    }

}
