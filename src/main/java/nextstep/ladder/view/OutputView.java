package nextstep.ladder.view;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.Members;

public class OutputView {

	private static final String RESULT_TITLE_TEXT = "실행 결과";
	private static final String LINE_START_TEXT = "     |";
	private static final String MEMBER_ICON_TEXT = "|";

	public static void runResult(Members members, Ladder ladder) {
		System.out.println(RESULT_TITLE_TEXT);
		printMembers(members);
		printLadder(ladder);
	}

	private static void printMembers(Members members) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < members.size(); i++) {
			System.out.printf("%6s", members.member(i).getName());
		}

		System.out.println();
	}

	private static void printLadder(Ladder ladder) {
		for (int i = 0; i < ladder.size(); i++) {
			Line line = ladder.getLine(i);
			System.out.print(LINE_START_TEXT);

			printLine(line);
			System.out.println();
		}
	}

	private static void printLine(Line line) {
		for (int j = 0; j < line.size(); j++) {
			System.out.print(line.getLadderStatus(j).getText());
			System.out.print(MEMBER_ICON_TEXT);
		}
	}
}
