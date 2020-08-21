package ladder.domain;

import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;

public class Persons implements Iterable<Person>, Printable {

    public static final String PERSON_NAME_DELIMITER = ",";
    public static final String BLANK_TEXT_MESSAGE = "The text cannot be blank";

    private final List<Person> persons;

    public Persons(List<Person> persons) {
        this.persons = persons;
    }

    public static Persons fromText(String text) {
        checkArgument(StringUtils.isNotBlank(text), BLANK_TEXT_MESSAGE);

        String[] names = text.split(PERSON_NAME_DELIMITER);

        List<Person> persons = new ArrayList<>();
        for (String name : names) {
            persons.add(new Person(name.trim()));
        }
        return new Persons(persons);
    }

    public int size() {
        return persons.size();
    }

    @Nonnull
    @Override
    public Iterator<Person> iterator() {
        return persons.iterator();
    }

    @Override
    public String print() {
        return persons.stream()
                .map(Person::print)
                .collect(Collectors.joining(" "));
    }
}
