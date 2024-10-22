package ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private final List<Line> lines;

    public Lines(int memberSize, int height, CreateStrategy createStrategy) {
        this(IntStream.range(0, height)
                .mapToObj(num -> new Line(memberSize, createStrategy))
                .collect(Collectors.toList()));
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public int getSize() {
        return lines.size();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public LadderResult playLadders(Members members, Rewords rewords) {
        if (members.getSize() != rewords.getSize()) {
            throw new IllegalStateException("사다리 게임을 진행할 수 없습니다.");
        }
        List<Integer> point = getResultPoints(members.getSize());
        return new LadderResult(getResultMap(point, members, rewords));
    }

    private List<Integer> getResultPoints(int memberCount) {
        List<Integer> point = IntStream.range(0, memberCount)
                .boxed()
                .collect(Collectors.toList());
        for (Line line : lines) {
            point = line.moveResult(point);
        }
        return point;
    }

    private Map<Member, Reword> getResultMap(List<Integer> point, Members members, Rewords rewords) {
        Map<Member, Reword> map = new LinkedHashMap<>();
        IntStream.range(0, members.getSize())
                .forEach(index -> map.put(members.getMember(index), rewords.get(point.get(index))));
        return map;
    }
}
