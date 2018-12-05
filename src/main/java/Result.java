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
	
	public static Result getResult(List<Result> results, List<Person> persons, List<LadderLine> ladderLines, String name) {
		Person person = Person.findByName(persons, name);
		int idx = persons.indexOf(person);
		
		return results.get(LadderLine.move(idx, ladderLines));
	}
	
	public String getValue() {
		return value;
	}
}
