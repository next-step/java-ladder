package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderFactory;
import ladder.domain.LadderGame;
import ladder.dto.InputDTO;
import ladder.view.InputView;
import ladder.view.OutputView;

/**
 * Created by seungwoo.song on 2022-10-17
 */
public class Application {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		InputDTO inputDTO = inputView.readInputValue();
		Ladder ladder = LadderFactory.create(inputDTO);

		OutputView outputView = new OutputView();
		outputView.print(ladder, inputDTO);

		LadderGame ladderGame = new LadderGame();
		ladderGame.start(ladder, inputDTO);

		while (true) {
			String selectedPerson = inputView.readSelectedPerson();
			outputView.print(inputDTO.getLadderGameResults(), inputDTO, selectedPerson);
		}
	}
}
