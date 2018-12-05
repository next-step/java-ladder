import java.util.List;

public class ResultView {
	public static void printLadder(LadderGame ladderGame, List<Result> results) {
		System.out.println();
		System.out.println("사다리 결과");
		System.out.println();
		printPeople(ladderGame);
		printLadderLines(ladderGame);
		System.out.println();
		printResults(results);
		
		System.out.println();
	}
	
	private static void printResults(List<Result> results) {
		results.stream()
				.forEach(r -> {
					System.out.printf("%-6s", r.getValue());
				});
	}
	
	private static void printLadderLines(LadderGame ladderGame) {
		ladderGame.getLadderLines().stream()
				.forEach(l -> {
					printPoints(l);
				});
	}
	
	private static void printPoints(LadderLine l) {
		System.out.println();
		l.getPoints().stream()
				.forEach(p->{
					System.out.printf("%-6s",p.getLine());
				});
	}
	
	private static void printPeople(LadderGame ladderGame) {
		ladderGame.getPersons().stream()
				.forEach(p -> {
					System.out.printf("%-6s",p.getName());
				});
	}
	
	public static void printResult(LadderGame ladderGame, List<Result> results, String name) {
		System.out.println();
		System.out.println("실행결과");
		if(Person.isAll(name)) {
			printResults(ladderGame, results);
			
		} else {
			printResultOne(ladderGame, results, name);
		}
	
	}
	
	private static void printResultOne(LadderGame ladderGame, List<Result> results, String name) {
		System.out.println(name + " : "
				+ Result.getResult(results, ladderGame.getPersons(), ladderGame.getLadderLines(), name).getValue());
	}
	
	private static void printResults(LadderGame ladderGame, List<Result> results) {
		ladderGame.getPersons()
				.stream()
				.forEach(p -> {
					printResultOne(ladderGame, results, p.getName());
				});
	}
	
}
