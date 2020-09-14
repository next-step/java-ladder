package cc.oakk.ladder.model.line;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import cc.oakk.ladder.model.line.dto.LineDto;
import cc.oakk.ladder.model.size.LadderWidth;
import cc.oakk.ladder.view.printer.Printable;
import cc.oakk.ladder.view.printer.Printer;

public class Line implements Printable<LineDto> {
    private final LadderWidth width;
    private final List<Connection> connections;

    private Line(int width, List<Connection> connections) {
        this.width = new LadderWidth(width);
        this.connections = connections;
    }

    public static Line of(boolean... connectedPoints) {
        List<Connection> connections = new ArrayList<>();
        Connection connection = Connection.start(connectedPoints[0]);
        connections.add(connection);
        for (int i = 1; i < connectedPoints.length; i++) {
            connection = connection.next(connectedPoints[i]);
            connections.add(connection);
        }
        connections.add(connection.end());
        return new Line(connections.size(), connections);
    }

    public LineDto getDto() {
        return new LineDto(width, connections);
    }

    public int width() {
        return width.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(width, line.width) &&
                Objects.equals(connections, line.connections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, connections);
    }

    @Override
    public void print(Printer<LineDto> printer) {
        printer.print(getDto());
    }
}
