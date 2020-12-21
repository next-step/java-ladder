package ladder.domain.next;

import ladder.domain.*;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NextLadder implements Ladder {

    private List<LadderLine> lines;
    private LadderMemberAndResult memberAndResults;

    public NextLadder(List<String> memberNames, List<String> results, List<LadderLine> lines) {
        this.memberAndResults = new LadderMemberAndResult(memberNames, results);
        this.lines = lines;
    }

    public NextLadder(List<String> memberNames, List<String> results, int height){
        this(memberNames, results, generateLines(memberNames.size(), height) );
    }

    private static List<LadderLine> generateLines(int sizeOfMember, int countOfLine) {
        if (countOfLine < 1) throw new IllegalArgumentException("사다리 라인은 최소 1이상 이어야 합니다");
        return IntStream.range(0, countOfLine)
                .mapToObj(idx -> LadderLine.init(sizeOfMember))
                .collect(Collectors.toList());
    }


    @Override
    public LadderResult startFrom(LadderMember member) {
        int startPos = member.getPos();
        int currentPos = startPos;
        for( LadderLine line: lines ){
            currentPos = line.move(currentPos);
        }
        return memberAndResults.getResult(currentPos);
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

    @Override
    public void print(PrintWriter writer) {
        writer.println(memberAndResults.toStringMembers());
        lines.forEach(writer::println);
        writer.println(memberAndResults.toStringResults());
        writer.flush();
    }
}
