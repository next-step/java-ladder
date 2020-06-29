package study2.domain;

import java.util.Collections;

public class ExecuteResult {

	String[] excuteResult;
	
	public ExecuteResult(String executeResult) {
		this.excuteResult = executeResult.replace(" ", "").split(",");
	}
	
	public String[] getExecuteResult() {
		return excuteResult;
	}
}
