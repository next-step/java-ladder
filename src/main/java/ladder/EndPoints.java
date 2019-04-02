package ladder;

import java.util.List;
import java.util.stream.Collectors;

public class EndPoints {
    protected final List<? extends EndPoint> endPoints;

    public EndPoints(String str) {
        this(parse(StringUtils.split(str)));
    }

    protected EndPoints(List<? extends EndPoint> endPoints) {
        this.endPoints = endPoints;
    }

    private static List<EndPoint> parse(List<String> strings) {
        return strings.stream().map(EndPoint::new).collect(Collectors.toList());
    }

    public boolean isEqualCount(EndPoints otherEndPoints) {
        return endPoints.size() == otherEndPoints.endPoints.size();
    }

    public int getCount() {
        return endPoints.size();
    }

    @Override
    public String toString() {
        return EndPoint.BLANK + String.join(EndPoint.BLANK,
                endPoints.stream()
                        .map(EndPoint::toString)
                        .collect(Collectors.toList()));
    }

    public EndPoint find(int destination) {
        return this.endPoints.get(destination);
    }
}
