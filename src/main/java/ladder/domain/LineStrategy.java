package ladder.domain;

import java.util.List;

public interface LineStrategy {
	List<Boolean> points(int countOfPerson);
}
