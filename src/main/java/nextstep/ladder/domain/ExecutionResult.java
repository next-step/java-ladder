package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import nextstep.ladder.util.CollectionUtils;

public class ExecutionResult {
	private static final String EMPTY_MESSAGE = "실행결과 리스트가 비어있습니다.";

	private final List<String> values;

	private ExecutionResult(List<String> values) {
		validateSize(values);
		this.values = new ArrayList<>(values);
	}

	private void validateSize(List<String> values) {
		if (CollectionUtils.isEmpty(values)) {
			throw new IllegalArgumentException(EMPTY_MESSAGE);
		}
	}

	public static ExecutionResult create(List<String> values) {
		return new ExecutionResult(values);
	}

	public String getResult(int index) {
		return values.get(index);
	}

	public List<String> getValues() {
		return Collections.unmodifiableList(values);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		ExecutionResult that = (ExecutionResult)obj;

		return Objects.equals(values, that.values);
	}

	@Override
	public int hashCode() {
		return Objects.hash(values);
	}

	@Override
	public String toString() {
		return "ExecutionResult{" +
			"values=" + values +
			'}';
	}
}
