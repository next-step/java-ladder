package nextstep.ladder;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Members;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderMain {

	public static void main(String[] args) {
		String names = InputView.inputName();
		int height = InputView.inputHeight();

		Members members = Members.of(names);

		Ladder ladder = Ladder.of(height, members.size());

		OutputView.runResult(members, ladder);
	}
}
