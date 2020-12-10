package ladder.domain;

import ladder.util.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Persons {
    private static int MAX_NAME_LENGTH = 5;
    private static int MIN_COUNT_OF_PERSON = 2;
    private List<Person> persons = new ArrayList<>();

    public Persons(final String names) {
        checkInputName(names);
        initNames(names);
    }

    public Persons(Persons persons, List<Integer> positionList) {
        checkListSize(persons.getPersons().size(), positionList.size());

        Person person = null;
        this.persons = new ArrayList<>();

        for (int i = 0; i < persons.getPersons().size(); i++) {
            person = new Person(persons.getPersons().get(i).getName(), positionList.get(i));
            this.persons.add(person);
        }
    }

    private void checkListSize(int first, int second) {
        if (first != second) {
            throw new RuntimeException(ErrorMessage.getCheckPersonsInit());
        }
    }

    private void initNames(final String names) {
        List<String> nameList = Arrays.asList(names.replaceAll(" ", "").split(","));

        checkMakeList(nameList);
        checkCountOfPerson(nameList.size());
        addPerson(nameList);
    }

    private void addPerson(final List<String> names) {
        Person person;

        for (int i = 0; i < names.size(); i++) {
            person = new Person(names.get(i));
            persons.add(person);
        }
    }

    private void checkMakeList(List<String> nameList) {
        if (nameList.isEmpty()) {
            throw new RuntimeException(ErrorMessage.getCheckInputNames());
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

    private void checkCountOfPerson(int countOfPerson) {
        if (countOfPerson < MIN_COUNT_OF_PERSON) {
            throw new RuntimeException(ErrorMessage.getCheckCountOfPerson());
        }
    }

    public List<Person> getPersons() {
        return persons;
    }
}