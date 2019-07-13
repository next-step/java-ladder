package ladder.view.out;

import ladder.domain.Ladder;

import java.util.List;
import java.util.stream.Collectors;

public class LadderViewer {

	private static final String RAIL_WITH_STEP = "-----|";

	private static final String RAIL_WITHOUT_STEP = "     |";

	private static final String NAME_FORMAT = "%6s";	// 6 is step's width(5) + rail(1)

	private static final int STEP_WIDTH = 5 ;

	private final MessageRenderer renderer;

	public LadderViewer(MessageRenderer renderer){
		this.renderer = renderer;
	}

	public void renderNames(List<String> playerNames){
		String names = playerNames
				.stream()
				.map(name -> String.format(NAME_FORMAT, name.length() < STEP_WIDTH ? name : name.substring(0, STEP_WIDTH)))
				.collect(Collectors.joining());

		renderer.print(names);
	}

	public void render(Ladder ladder){
		ladder.getRows().forEach(row -> {
			String rendered = row.getSteps()
					.map(step -> step ? RAIL_WITH_STEP : RAIL_WITHOUT_STEP)
					.collect(Collectors.joining());

			renderer.print(rendered);
		});
	}

	public void renderGoals(List<String> goals) {
		String names = goals
				.stream()
				.map(name -> String.format(NAME_FORMAT, name.length() < STEP_WIDTH ? name : name.substring(0, STEP_WIDTH)))
				.collect(Collectors.joining());

		renderer.print(names);
	}
}
