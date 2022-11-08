package ladder;

import ladder.domain.Ladder;
import ladder.dto.InputDTO;
import ladder.util.RandomUtil;
import ladder.view.InputView;
import ladder.view.OutputView;

/**
 * Created by seungwoo.song on 2022-11-07
 */
public class Application {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		InputDTO inputDTO = inputView.readInputValue();

		Ladder ladder = Ladder.of(
			inputDTO.getHeight(),
			inputDTO.getPersons().size(),
			() -> RandomUtil.generateRandomBoolean());

		OutputView outputView = new OutputView();
		outputView.print(ladder, inputDTO);

		while (true) {
			String selectedPerson = inputView.readSelectedPerson();
			outputView.print(inputDTO.getLadderGameResults(), inputDTO, selectedPerson);
		}
	}

}
