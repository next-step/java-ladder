package laddergame.domain;

import java.util.Random;

public interface RandomDirectionStrategy {

	Random random = new Random();

	int random();
}
