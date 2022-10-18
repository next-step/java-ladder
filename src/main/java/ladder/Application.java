package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderFactory;
import ladder.view.InputView;
import ladder.view.OutputView;

/**
 * Created by seungwoo.song on 2022-10-17
 */
public class Application {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		InputDTO inputDTO = inputView.read();

		LadderFactory ladderFactory = new LadderFactory();
		Ladder ladder = ladderFactory.create(inputDTO);

		OutputView outputView = new OutputView();
		outputView.print(ladder, inputDTO);
	}
}
