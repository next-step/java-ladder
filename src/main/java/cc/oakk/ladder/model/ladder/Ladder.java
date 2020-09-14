package cc.oakk.ladder.model.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import cc.oakk.ladder.model.ladder.dto.LadderDto;
import cc.oakk.ladder.model.line.Line;
import cc.oakk.ladder.model.size.LadderHeight;
import cc.oakk.ladder.model.trace.Trace;
import cc.oakk.ladder.model.trace.TraceResults;

public class Ladder {
    private static final BinaryOperator<Trace> IDENTITY = (a, b) -> a;

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int height, LadderInitializer initializer) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < new LadderHeight(height).get(); i++) {
            lines.add(Line.of(initializer.provideConnections(i)));
        }
        return new Ladder(lines);
    }

    public LadderDto getDto() {
        return new LadderDto(lines.stream()
                .map(Line::getDto)
                .collect(Collectors.toList()));
    }

    public Trace trace(Trace of) {
        return lines.stream()
                .reduce(of, Trace::move, IDENTITY);
    }

    public TraceResults traceAll() {
        TraceResults traceResults = new TraceResults();
        for (int i = 0; i < width(); i++) {
            traceResults.addTraceResult(Trace.of(i), trace(Trace.of(i)));
        }
        return traceResults;
    }

    public int width() {
        return lines.get(0).width();
    }

    public int height() {
        return lines.size();
    }
}
