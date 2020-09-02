package step2;

import step2.domain.Ladder;
import step2.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LadderApplication {
	public static void main(String[] args) {
		String[] usersName = InputView.inputUsersName();
		int ladderHeight = InputView.inputLadderHeight();

		List<Ladder> ladderList = new ArrayList<>();
		for (String name : usersName) {
			ladderList.add(new Ladder(name, ladderHeight));
		}

	}
}
