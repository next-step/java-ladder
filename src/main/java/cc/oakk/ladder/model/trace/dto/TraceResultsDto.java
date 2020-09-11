package cc.oakk.ladder.model.trace.dto;

import cc.oakk.ladder.model.trace.Trace;

import java.util.Collections;
import java.util.Map;

import static cc.oakk.ladder.util.ValidationUtils.throwIfNull;

public class TraceResultsDto {
    private final Map<Trace, Trace> traceResults;

    public TraceResultsDto(Map<Trace, Trace> traceResults) {
        this.traceResults = Collections.unmodifiableMap(traceResults);
    }

    public Trace getTraceResult(Trace start) {
        if (!traceResults.containsKey(throwIfNull(start))) {
            throw new IllegalArgumentException("결과가 존재하지 않는 시작점입니다.");
        }
		return traceResults.get(start);
	}
}
