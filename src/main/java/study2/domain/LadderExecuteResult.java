package study2.domain;

import java.util.Collections;

public class LadderExecuteResult {
	// 새로운 패키지에 구현했어야 했는데요 아차 하고 study2패키지에 이어서 구현해버렸습니다.
	// 무시해주시면 됩니당 !
	String[] excuteResult;
	
	public LadderExecuteResult(String executeResult) {
		this.excuteResult = executeResult.replace(" ", "").split(",");
	}
	
	public String[] getExecuteResult() {
		return excuteResult;
	}
}
