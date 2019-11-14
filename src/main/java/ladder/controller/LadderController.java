package ladder.controller;

import ladder.domain.LadderInput;
import ladder.domain.ladder.Ladder;
import ladder.domain.policy.PointConnectRandomly;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

	public static void start() {
		Ladder ladder = createAndPrintLadder();
		showResult(ladder);
	}

	private static Ladder createAndPrintLadder() {
		LadderInput ladderInput = new LadderInput(InputView.receivePeopleName(),
				InputView.receiveLadderResult());
		Ladder ladder = new  Ladder(new PointConnectRandomly(), ladderInput, InputView.receiveLadderHeight());
		ResultView.printLadder(ladder);
		return ladder;
	}

	// TODO: 2019-11-13 여기를 리팩토링 할 수 있을까?
	//   요구사항 : ALL 이 입력되면 전체 결과를 출력하고 그만하기, 다른 이름이 입력되면 결과를 출력하고 계속 반복하기
	//   반복하다가 조건부로 멈춰야하기 때문에 무한루프 + if + break 를 쓸 수 밖에 없지 않을까
	private static void showResult(Ladder ladder) {
		while (true) {
			String name = InputView.receivePersonNameToShowResult();
			if ("ALL".equals(name)) {
				ResultView.printAllResult(ladder.getAllResult());
				break;
			} else {
				ResultView.printResult(ladder.getResult(name));
			}
		}
	}

}
