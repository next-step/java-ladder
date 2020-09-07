package cc.oakk.ladder.model.line;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import cc.oakk.ladder.model.size.LadderWidth;
import cc.oakk.ladder.util.ValidationUtils;
import cc.oakk.ladder.view.printer.Printable;
import cc.oakk.ladder.view.printer.Printer;

public class Line implements Printable<Line> {
    protected final LadderWidth width;
    protected final List<MutableConnection> connections;

    public Line(int width) {
        this.width = new LadderWidth(width);
        this.connections = Collections.unmodifiableList(IntStream.range(0, width - 1)
                                    .boxed()
                                    .map(dummy -> new MutableConnection(false))
                                    .collect(Collectors.toList()));
    }

    public Connection isConnected(int index) {
        ValidationUtils.throwIfOutOfListSize(connections, index);
		return connections.get(index);
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
    public void print(Printer<Line> printer) {
        printer.print(this);
    }
}
