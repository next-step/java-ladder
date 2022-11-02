package nextstep.step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Link> links = new ArrayList<>();

    private Line(final int countOfParticipant){
        RandomLineGenerator randomLineGenerator = RandomLineGenerator.from(countOfParticipant);
        for (int position = 1; position <= countOfParticipant; position++) {
            links.add(Link.from(randomLineGenerator.createRandomBoolean(position)));
        }
    }

    public static Line from(final int countOfParticipant){
        return new Line(countOfParticipant);
    }

    public List<Link> getLinks() {
        return links;
    }
}
