package ladder.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 미리 정의된 순서로 가로계단을 공급하는 객체
 */
public class PredefinedStepProvider implements StepProvider {

	private LinkedList<Boolean> steps;

	public PredefinedStepProvider(List<Boolean> predefinedSteps) {
		this.steps = predefinedSteps.stream().collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	public boolean generate() {
		return steps.pollFirst();
	}
}
