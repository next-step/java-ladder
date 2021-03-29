package ladder.domain.ladder;

import ladder.constants.Constants;
import ladder.domain.participant.ParticipantList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private List<Point> points;
    private List<Link> links;

    public Line(ParticipantList participantList) {
        this.points = points(participantList);
        this.links = links(participantList);
    }

    private List<Point> points(ParticipantList participantList) {
        return IntStream.range(0, participantList.size())
                .mapToObj(Point::new)
                .collect(Collectors.toList());
    }

    private List<Link> links(ParticipantList participantList) {
        Link.init();
        return IntStream.range(Constants.ZERO, participantList.size() - 1)
                .mapToObj(Link::new)
                .filter(link -> !link.empty())
                .collect(Collectors.toList());
    }

    public List<Link> links() {
        return this.links;
    }

    public List<Point> points() {
        return this.points;
    }

    protected int movedIndex(int index) {
        return this.links.stream()
                .filter(link -> (link.from() == index || link.to() == index))
                .map(link -> link.matchedValue(index))
                .findFirst()
                .orElse(index);
    }
}
