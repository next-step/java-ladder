package laddergame.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Boolean.FALSE;

public class BaseDomainTest {

    protected EndPoints getEndPoints(List<String> names) {
        return new EndPoints(
                IntStream.range(0, names.size())
                        .mapToObj(i -> new EndPoint(names.get(i), i))
                        .collect(Collectors.toList())
        );
    }

    protected LadderLine getLadderLine(List<Boolean> links) {

        List<Point> points = new ArrayList<>();

        if( links.size() > 0 ) {
            points.add(new Point(0, Direction.of(FALSE, links.get(0))));

            for (int i = 1; i < links.size(); ++i) {
                points.add(new Point(i, Direction.of(links.get(i - 1), links.get(i))));
            }

            points.add(new Point(links.size(), Direction.of(links.get(links.size() - 1), FALSE)));
        }

        return new LadderLine(points);
    }

    protected LadderLines getLadderLines(List<List<Boolean>> linksPerLine) {

        List<LadderLine> ladderLines = new ArrayList<>();

        for(List<Boolean> curLinks : linksPerLine) {
            ladderLines.add(getLadderLine(curLinks));
        }

        return new LadderLines(ladderLines);
    }

    protected Map<EndPoint, EndPoint> getGameResult(EndPoints participants, EndPoints rewards, List<List<Integer>> pointIndexPairs) {

        Map<EndPoint, EndPoint> gameResult = new LinkedHashMap<>();

        for( List<Integer> curIndexPair : pointIndexPairs ) {
            gameResult.put(participants.getEndPoint(curIndexPair.get(0)), rewards.getEndPoint(curIndexPair.get(1)));
        }

        return gameResult;
    }
}