package ladder;

import ladder.domain.*;
import ladder.util.TrimSplitter;
import ladder.view.in.InputDialog;
import ladder.view.out.LadderViewer;
import ladder.view.out.MessageRenderer;

import java.util.List;

public class GameController {

	private static final String SEPARATOR = ",";

	private static final String BRIEF_ALL = "all";

	private LadderViewer view;

	private LadderHeader header;

	public GameController(MessageRenderer renderer){
		this.view = new LadderViewer(renderer);
	}


	public void ready(InputDialog input, StepProvider provider){
		String nameInput = input.execute("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		List<String> playerNames = TrimSplitter.split(nameInput, SEPARATOR);

		String goalInput = input.execute("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
		List<String> goals = TrimSplitter.split(goalInput, SEPARATOR);

		int height = Integer.parseInt(input.execute("최대 사다리 높이는 몇 개인가요?"));

		LadderFooter footer = new LadderFooter(goals);
		LadderBody ladderBody = new LadderBody(playerNames.size(), height, provider, footer);
		this.header = new LadderHeader(playerNames, ladderBody);

		view.renderLabels(playerNames);
		view.render(ladderBody);
		view.renderLabels(goals);
	}

	public void briefResult(InputDialog input, MessageRenderer renderer){

		while(true) {
			String commandOrPlayerName = input.execute("결과를 보고 싶은 사람은?").trim();
			renderer.print("실행 결과");
			if(BRIEF_ALL.equals(commandOrPlayerName)){
				break;
			}
			renderer.print(header.getGoal(commandOrPlayerName));
		}

		List<NameGoalPair> results = header.getResult();
		results.forEach(nameGoalPair -> renderer.print(nameGoalPair.toStringWithDelimiter(" : ")));
	}
}
