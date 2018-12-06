import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ResultTest {
	public static final String POBI = "pobi";
	List<Person> persons;
	List<Result> results;
	@Before
	public void setUp() throws Exception {
		persons = Person.getPersons("pobi,honux,lion,pk".split(","));
		results = Result.getResults("꽝,1000,2500,3000".split(","));
	}

	@Test
	public void getResult() {
		LadderGame ladderGame = new LadderGame(persons, new DefaultLadderLineGenerator(new Positive(5)));
		ResultView.printLadder(ladderGame, results);
		ResultView.printResult(ladderGame, results, POBI);
		ResultView.printResult(ladderGame, results, Person.ALL);
	}

	@Test
	public void getResult_상() {
		LadderGame ladderGame = new LadderGame(persons, new LevelLadderLineGenerator(Level.상));
		ResultView.printLadder(ladderGame, results);
		ResultView.printResult(ladderGame, results, POBI);
		ResultView.printResult(ladderGame, results, Person.ALL);
	}

	@Test
	public void getResult_중() {
		LadderGame ladderGame = new LadderGame(persons, new LevelLadderLineGenerator(Level.중));
		ResultView.printLadder(ladderGame, results);
		ResultView.printResult(ladderGame, results, POBI);
		ResultView.printResult(ladderGame, results, Person.ALL);
	}

	@Test
	public void getResult_하() {
		LadderGame ladderGame = new LadderGame(persons, new LevelLadderLineGenerator(Level.하));
		ResultView.printLadder(ladderGame, results);
		ResultView.printResult(ladderGame, results, POBI);
		ResultView.printResult(ladderGame, results, Person.ALL);
	}
}