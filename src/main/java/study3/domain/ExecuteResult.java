package study3.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ExecuteResult {

	private final String executeReuslt;

	public ExecuteResult(String executeResult) {
				
		this.executeReuslt = executeResult;		
	}

	public String getExecuteResult() {
		return executeReuslt;
	}
	
}
