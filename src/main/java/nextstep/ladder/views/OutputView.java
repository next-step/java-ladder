package nextstep.ladder.views;

import nextstep.ladder.entity.Ladder;

public class OutputView extends View {
	public void showResult(Ladder ladder) {
		out.println("실행 결과");
		out.println(ladder);
	}
}
