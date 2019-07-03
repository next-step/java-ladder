package ladder.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PredefinedStepProvider implements StepProvider {

	private LinkedList<Boolean> steps;

	public PredefinedStepProvider(List<Boolean> predefinedSteps) {
		this.steps = predefinedSteps.stream().collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	public boolean isInstallStep() {
		return steps.pollFirst();
	}
}
