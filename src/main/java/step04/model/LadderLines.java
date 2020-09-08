package step04.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLines {
    private static final int START_INDEX = 0;

    private final List<LadderLine> ladderLineList;

    private LadderLines(List<LadderLine> ladderLineList) {
        this.ladderLineList = Collections.unmodifiableList(ladderLineList);
    }

    public static LadderLines of(int lineNum, int userNum, LadderMakeStrategy ladderMakeStrategy) {
        return new LadderLines(IntStream.range(START_INDEX, lineNum)
                .mapToObj(i -> LadderLine.of(userNum, ladderMakeStrategy))
                .collect(Collectors.toList()));
    }

    public String getPrintableString() {
        return ladderLineList.stream()
                .map(LadderLine::getPrintableLadderLine)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public RouteInfo<Integer> getRouteInfo() {
        return RouteInfo.navigateRoutes(getRouteInfoList());
    }

    private List<RouteInfo<Integer>> getRouteInfoList() {
        return ladderLineList.stream()
                .map(LadderLine::getRouteInfo)
                .collect(Collectors.toList());
    }
}
