package ladder.util;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TrimSplitter {

	public static List<String> split(String input, String separator){
		return Arrays.stream(Optional.ofNullable(input).orElse("").split(separator))
				.map(String::trim)
				.collect(Collectors.toList());
	}

}
