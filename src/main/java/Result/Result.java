package Result;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Result {
	private String value;
	
	public Result(String value) {
		this.value = value;
	}
	
	public static List<Result> getResults(String[] split) {
		return Arrays.stream(split)
				.map(Result::new)
				.collect(Collectors.toList());
	}
}
