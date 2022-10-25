package ladder.domain;

/**
 * Created by seungwoo.song on 2022-10-25
 */
public class LadderGame {
	public LadderGameResult start(Ladder ladder, LadderGameResults results, Person person) {

		for (LadderRow row : ladder) {
			row.movePerson(person);
		}

		return results.get(person);
	}
}
