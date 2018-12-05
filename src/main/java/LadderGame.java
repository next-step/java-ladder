import java.util.ArrayList;
import java.util.List;

public class LadderGame {
	private List<LadderLine> ladderLines = new ArrayList<LadderLine>();
	private List<Person> persons;
	
	public LadderGame(List<Person> persons, Positive height, LadderLineGen ladderLineGen) {
		ladderLines = ladderLineGen.getLadderLines(height, persons.size());
		this.persons = persons;
	}
	
	public List<LadderLine> getLadderLines() {
		return ladderLines;
	}
	
	public List<Person> getPersons() {
		return persons;
	}
}
