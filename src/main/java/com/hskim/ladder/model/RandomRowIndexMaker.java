package com.hskim.ladder.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

public class RandomRowIndexMaker implements RowIndexMaker {
    private static final Random random = new Random();
    private static final int BOUND_REVISE_NUMBER = 1;

    @Override
    public List<Integer> getNumbers(int bound) {
        int repeatNumber = random.nextInt(bound - BOUND_REVISE_NUMBER) + BOUND_REVISE_NUMBER;
        List<Integer> result = new LinkedList<>();
        Set<Integer> collisionCheckSet = new HashSet<>();
        for (int index = 0; index < repeatNumber; index++) {
            getNonCollisionIndex(collisionCheckSet, bound)
                    .ifPresent(result::add);
        }

        return result;
    }

    private Optional<Integer> getNonCollisionIndex(Set<Integer> collisionCheckSet, int bound) {
        int result = random.nextInt(bound - BOUND_REVISE_NUMBER) + BOUND_REVISE_NUMBER;

        if (collisionCheckSet.contains(result)) {
            return Optional.empty();
        }

        collisionCheckSet.add(result - 1);
        collisionCheckSet.add(result);
        collisionCheckSet.add(result + 1);

        return Optional.of(result);
    }

}
