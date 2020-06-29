package study3.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderExecuteResult {

	private final String executeReuslt;

	public LadderExecuteResult(String executeResult) {				
		this.executeReuslt = executeResult;		
	}

	public String getExecuteResult() {
		return executeReuslt;
	}
	
	public static Rewards executeReward(String executeString) {
		return new Rewards (
				Arrays.stream(executeString.replace(" ", "")
				.split(","))
				.collect(Collectors.toList()));
	}
}
