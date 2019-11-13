package ladder.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderExecutionResult {

	private final Map<String, String> executionResult = new LinkedHashMap<>();

	public void add(String name, String result) {
		executionResult.put(name, result);
	}

	public List<String> getNames() {
		return new ArrayList<>(executionResult.keySet());
	}

	public String getExecutionResult(String name) {
		return executionResult.get(name);
	}

}
