package ladder;

import ladder.domain.*;
import ladder.model.NameGoalPair;
import ladder.domain.StepProvider;
import ladder.util.TrimSplitter;
import ladder.view.in.InputDialog;
import ladder.view.out.LadderViewer;
import ladder.view.out.MessageRenderer;

import java.util.List;

public class GameController {

	private static final String SEPARATOR = ",";

	private static final String BRIEF_ALL = "all";

	private Ladder ladder;

	public void ready(InputDialog input, MessageRenderer renderer){
		this.ready(input, renderer, null);
	}

	public void ready(InputDialog input, MessageRenderer renderer, StepProvider provider){
		String nameInput = input.execute("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		List<String> playerNames = TrimSplitter.split(nameInput, SEPARATOR);

		String goalInput = input.execute("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
		List<String> goals = TrimSplitter.split(goalInput, SEPARATOR);

		int height = Integer.parseInt(input.execute("최대 사다리 높이는 몇 개인가요?"));

		Ladder.Builder builder = Ladder.builder()
				.setPlayerNames(playerNames)
				.setGoals(goals)
				.setHeight(height);

		if(provider != null) {
			builder = builder.setStepProvider(provider);
		}

		this.ladder = builder.build();

		LadderViewer viewer = new LadderViewer(renderer);
		viewer.renderLabels(playerNames);
		viewer.render(ladder.getNodes());
		viewer.renderLabels(goals);
	}

	public void briefResult(InputDialog input, MessageRenderer renderer){

		while(true) {
			String commandOrPlayerName = input.execute("결과를 보고 싶은 사람은?").trim();
			renderer.print("실행 결과");
			if(BRIEF_ALL.equals(commandOrPlayerName)){
				break;
			}
			renderer.print(ladder.getGoal(commandOrPlayerName));
		}

		List<NameGoalPair> results = ladder.getResult();
		results.forEach(nameGoalPair -> renderer.print(nameGoalPair.toStringWithDelimiter(" : ")));
	}
}
