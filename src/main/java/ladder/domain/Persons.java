package ladder.domain;

public class Persons {
    private Persons(String[] personNames) {

    }

    public static Persons getInstanceByPersonNames(String[] personNames) {
        return new Persons(personNames);
    }
}
