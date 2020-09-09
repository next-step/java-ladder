package cc.oakk.ladder.model.line;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import cc.oakk.ladder.model.line.dto.LineDto;
import cc.oakk.ladder.model.size.LadderWidth;
import cc.oakk.ladder.view.printer.Printable;
import cc.oakk.ladder.view.printer.Printer;

public class Line implements Printable<LineDto> {
    private final LadderWidth width;
    private final Connections connections;

    public Line(int width) {
        this.width = new LadderWidth(width);
        this.connections = new Connections(IntStream.range(0, width - 1)
                                    .boxed()
                                    .map(dummy -> Connection.of(false))
                                    .collect(Collectors.toList()));
    }

    public LineDto getDto() {
        return new LineDto(width, connections.getDto());
    }

    public boolean isConnected(int index) {
		return connections.isConnected(index);
	}

    public int width() {
        return width.get();
    }

    public Line connect(int index) {
        connections.connect(index);
        return this;
    }

    public Line connect(int... indexs) {
        for (int index : indexs) {
            connect(index);
        }
        return this;
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
