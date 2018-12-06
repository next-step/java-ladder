import java.util.List;

public class ConsoleMain {
	public static void main(String[] args) {
		List<Person> persons = Person.getPersons(InputView.getParticipants());
		List<Result> results = Result.getResults(InputView.getResults());
		Level level = Level.getLevel(InputView.getLevel());
		LadderGame ladderGame = new LadderGame(persons, new LevelLadderLineGenerator(level));
		ResultView.printLadder(ladderGame, results);
		
		for (int i = 0; i < 2; i++) {
			
			ResultView.printResult(ladderGame, results, InputView.getPersonResult());
		}
	}
}
