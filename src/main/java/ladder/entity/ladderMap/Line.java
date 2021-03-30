package ladder.entity.ladderMap;

import ladder.entity.moveStrategy.MoveStill;
import ladder.entity.moveStrategy.MoveStrategy;
import ladder.entity.moveStrategy.MoveStrategyJudge;
import ladder.entity.participant.ParticipantList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private final List<Point> points;
    private final List<Link> links;

    public Line(ParticipantList participantList) {
        this.points = points(participantList);
        this.links = links(points);
    }

    private List<Point> points(ParticipantList participantList) {
        return IntStream.range(0, participantList.size())
                .mapToObj(Point::new)
                .collect(Collectors.toList());
    }

    private List<Link> links(List<Point> points) {
        List<Link> stillLinks = stillLinks(points);
        if(stillLinks.isEmpty()){
            return stillLinks;
        }
        return updatedLinks(points, stillLinks);
    }

    private List<Link> updatedLinks(List<Point> points, List<Link> links) {
        List<Link> updatedLinks = new ArrayList<>();
        MoveStrategy firstMoveStrategy = MoveStrategyJudge.strategy(links.get(0));
        Link firstLink = new Link(points.get(0), firstMoveStrategy);
        updatedLinks.add(firstLink);
        for (int index = 1; index < links.size(); index++) {
            Link preLink = updatedLinks.get(updatedLinks.size() - 1);
            MoveStrategy moveStrategy = MoveStrategyJudge.strategy(preLink);
            updatedLinks.add(new Link(points.get(index), moveStrategy));
        }
        return updatedLinks;
    }

    private List<Link> stillLinks(List<Point> points) {
        List<Link> stillLinks = new ArrayList<>();
        for (int index = 0; index < points.size() - 1; index++) {
            stillLinks.add(new Link(points.get(index), new MoveStill()));
        }
        return stillLinks;
    }

    public List<Link> links() {
        return links;
    }
}
