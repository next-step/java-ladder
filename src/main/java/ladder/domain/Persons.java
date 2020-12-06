package ladder.domain;

import ladder.util.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Persons {
    private static int MAX_NAME_LENGTH = 5;

    private List<Person> persons = new ArrayList<>();

    public Persons(final String names) {
        checkInputName(names);
        initNames(names);
    }

    private void initNames(final String names) {
        List<String> nameList = Arrays.asList(names.replaceAll(" ", "").split(","));

        addPerson(nameList);
    }

    private void addPerson(final List<String> names) {
        Person person;

        for (String name : names) {
            person = new Person(name);
            persons.add(person);
        }
    }

    private void checkInputName(final String names) {
        checkNull(names);
        checkEmpty(names);
    }

    private void checkEmpty(final String names) {
        if (names == null) {
            throw new RuntimeException(ErrorMessage.getCheckInputNames());
        }
    }

    private void checkNull(final String names) {
        if (names.isEmpty()) {
            throw new RuntimeException(ErrorMessage.getCheckInputNames());
        }
    }

    public List<Person> getPersons() {
        return persons;
    }
}
