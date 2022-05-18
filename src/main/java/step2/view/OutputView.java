package step2.view;

import static java.lang.System.*;

public class OutputView {

	public void showCreationResult(String playersResult, String ladderResult) {
		show("실행 결과 - 생성");
		show(playersResult);
		show(ladderResult);
	}

	private void show(String output) {
		out.println(output);
	}
}
