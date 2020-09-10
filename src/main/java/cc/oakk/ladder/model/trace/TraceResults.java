package cc.oakk.ladder.model.trace;

import cc.oakk.ladder.model.trace.dto.TraceResultsDto;

import java.util.HashMap;
import java.util.Map;

import static cc.oakk.ladder.util.ValidationUtils.throwIfNull;

public class TraceResults {
    private final Map<Trace, Trace> traceResults = new HashMap<>();

	public void addTraceResult(Trace start, Trace end) {
        if (traceResults.containsKey(throwIfNull(start))) {
            throw new IllegalArgumentException("이미 존재하는 시작점입니다.");
        }

        if (traceResults.containsValue(throwIfNull(end))) {
            throw new IllegalArgumentException("이미 존재하는 끝점입니다.");
        }
        
        traceResults.put(start, end);
	}

	public Trace getTraceResult(Trace start) {
        if (!traceResults.containsKey(throwIfNull(start))) {
            throw new IllegalArgumentException("결과가 존재하지 않는 시작점입니다.");
        }
		return traceResults.get(start);
	}

	public TraceResultsDto getDto() {
	    return new TraceResultsDto(traceResults);
    }
}
