package refactoring.domain;

import refactoring.utils.RandomGenerator;

public enum LineStatus {
    CONNECTION, DETACHMENT;

    public static LineStatus generate() {
        return RandomGenerator.create() ? CONNECTION : DETACHMENT;
    }
}
