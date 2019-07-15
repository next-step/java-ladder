package ladder.view.out;

import ladder.model.LadderNode;

import java.util.List;
import java.util.stream.Collectors;

public class LadderViewer {

	private static final String RAIL_WITH_STEP = "-----|";

	private static final String RAIL_WITHOUT_STEP = "     |";

	private static final String LABEL_FORMAT = "%6s";	// 6 is step's width(5) + rail(1)

	private static final int STEP_WIDTH = 5 ;

	private final MessageRenderer renderer;

	public LadderViewer(MessageRenderer renderer){
		this.renderer = renderer;
	}

	public void renderLabels(List<String> labels){
		String renderMessage = labels
				.stream()
				.map(label -> String.format(LABEL_FORMAT, label.length() < STEP_WIDTH ? label : label.substring(0, STEP_WIDTH)))
				.collect(Collectors.joining());

		renderer.print(renderMessage);
	}

	public void render(List<LadderNode> nodes){
		String rendered = nodes.stream()
				.map(node -> {
					String value = node.hasStep() ? RAIL_WITH_STEP : RAIL_WITHOUT_STEP;
					if(node.isInLastRail()){
						value += "\n";
					}
					return value;
				})
				.collect(Collectors.joining());

		renderer.print(rendered);
	}
}
