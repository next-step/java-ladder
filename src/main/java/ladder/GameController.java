package ladder;

import ladder.domain.HorizontalStepList;
import ladder.domain.Ladder;
import ladder.domain.StepProvider;
import ladder.util.TrimSplitter;
import ladder.view.in.InputDialog;
import ladder.view.out.LadderViewer;
import ladder.view.out.MessageRenderer;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GameController {

	private static final String SEPARATOR = ",";

	private Ladder ladder;

	private LadderViewer view;

	public GameController(MessageRenderer renderer){
		this.view = new LadderViewer(renderer);
	}


	public void ready(InputDialog input, StepProvider provider){
		String nameInput = input.execute("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		List<String> playerNames = TrimSplitter.split(nameInput, SEPARATOR);

		int height = Integer.parseInt(input.execute("최대 사다리 높이는 몇 개인가요?"));

		this.ladder = IntStream.range(0, height)
				.mapToObj((i) -> new HorizontalStepList(playerNames.size(), provider))
				.collect(Ladder.collector());

		view.renderNames(playerNames);
		view.render(this.ladder);
	}
}
