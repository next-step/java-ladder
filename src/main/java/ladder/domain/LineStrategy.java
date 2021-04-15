package ladder.domain;

import java.util.List;

public interface LineStrategy {
	List<Cross> crosses(int countOfPerson);
}
