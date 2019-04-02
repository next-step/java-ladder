package domain;

import util.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {
    private static final String SEPARATOR = ",";
    private static final int MAX_NAME_LENGTH = 5;
    private List<String> persons = new ArrayList<>();

    public Person(String name) {
        if (name.trim().length() == 0) {
            throw new IllegalArgumentException(ErrorMessage.NONE_PLAYER.getErrorMessage());
        }

        Arrays.stream(name.split(SEPARATOR))
            .forEach(player -> {
                if (player.trim().length() > MAX_NAME_LENGTH) {
                    throw new IllegalArgumentException(ErrorMessage.NAME_EXCESS.getErrorMessage());
                }
                this.persons.add(player.trim());
            });
    }

    public int personCount() {
        return this.persons.size();
    }

    @Override
    public String toString() {
        return String.join("\t", this.persons);
    }
}
