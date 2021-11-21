package nextstep.ladder.dto;

import java.util.Map;

import nextstep.ladder.view.ResultView;

public class LadderResultDto {
	private static final String LAST_LINE_FEED = "\\s$";
	private static final String EMPTY = "";

	private final Map<String, String> resultMap;
	private final String all;

	public LadderResultDto(Map<String, String> resultMap) {
		this.resultMap = resultMap;
		this.all = calculateAll();
	}

	private String calculateAll() {
		StringBuilder builder = new StringBuilder();
		resultMap.forEach((key, value) -> {
			builder.append(key);
			builder.append(ResultView.ALL_DELIMITER);
			builder.append(value);
			builder.append(System.lineSeparator());
		});
		return builder.toString().replaceAll(LAST_LINE_FEED, EMPTY);
	}

	public String getResult(String key) {
		return resultMap.get(key);
	}

	public String getAll() {
		return all;
	}
}
