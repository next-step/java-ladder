package nextstep.ladder;

import java.util.List;

public class Line {
    private final List<Connection> connectionList;
    private final int length;


    public Line(List<Connection> connectionList, int length) {
        this.connectionList = connectionList;
        this.length = length;
    }
}
