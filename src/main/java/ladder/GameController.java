package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderContext;
import ladder.domain.NameGoalPair;
import ladder.domain.StepProvider;
import ladder.util.TrimSplitter;
import ladder.view.in.InputDialog;
import ladder.view.out.LadderViewer;
import ladder.view.out.MessageRenderer;

import java.util.List;
import java.util.Map;

public class GameController {

	private static final String SEPARATOR = ",";

	private static final String BRIEF_ALL = "all";

	private LadderViewer view;

	private LadderContext context;

	public GameController(MessageRenderer renderer){
		this.view = new LadderViewer(renderer);
	}


	public void ready(InputDialog input, StepProvider provider){
		String nameInput = input.execute("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		List<String> playerNames = TrimSplitter.split(nameInput, SEPARATOR);

		String goalInput = input.execute("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
		List<String> goals = TrimSplitter.split(goalInput, SEPARATOR);

		int height = Integer.parseInt(input.execute("최대 사다리 높이는 몇 개인가요?"));

		Ladder ladder = new Ladder(playerNames.size(), height, provider);
		this.context = new LadderContext(playerNames, goals, ladder);
		view.renderLabels(playerNames);
		view.render(ladder);
		view.renderLabels(goals);
	}

	public void briefResult(InputDialog input, MessageRenderer renderer){

		while(true) {
			String commandOrPlayerName = input.execute("결과를 보고 싶은 사람은?").trim();
			renderer.print("실행 결과");
			if(BRIEF_ALL.equals(commandOrPlayerName)){
				break;
			}
			renderer.print(context.getGoal(commandOrPlayerName));
		}

		List<NameGoalPair> results = context.getResult();
		results.forEach(nameGoalPair -> renderer.print(nameGoalPair.toStringWithDelimiter(" : ")));
	}
}
