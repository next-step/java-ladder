import org.junit.Test;

import java.util.List;

public class ResultTest {
	
	@Test
	public void getResult() {
		List<Person> persons = Person.getPersons("pobi,honux,lion,pk".split(","));
		List<Result> results = Result.getResults("꽝,1000,2500,3000".split(","));
		LadderGame ladderGame = new LadderGame(persons, new Positive(5), new DefaultLadderLineGen());
		ResultView.printLadder(ladderGame, results);
		ResultView.printResult(ladderGame, results, "pobi");
		ResultView.printResult(ladderGame, results, "all");
	}
}