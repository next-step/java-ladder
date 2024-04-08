package ladder.domain.ladder;

public class RandomPointLines implements LinesStrategy {
	@Override
	public Lines makeLines(int height, int countOfPerson) {
		return Lines.createRandomLines(height, countOfPerson);
	}
}
