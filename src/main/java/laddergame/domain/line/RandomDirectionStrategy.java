package laddergame.domain.line;

import java.util.Random;

public interface RandomDirectionStrategy {

	Random random = new Random();

	int random();
}
