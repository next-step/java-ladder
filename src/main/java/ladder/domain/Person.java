package ladder.domain;

import org.apache.commons.lang3.StringUtils;

import static com.google.common.base.Preconditions.checkArgument;

public class Person implements Printable {

    public static final int MAX_NAME_LENGTH = 5;
    public static final String BLANK_NAME_MESSAGE = "The person name cannot be blank";
    public static final String NAME_LENGTH_MESSAGE = "The person name can only be %s characters or less";

    private final String name;

    public Person(String name) {
        checkArgument(StringUtils.isNotBlank(name), BLANK_NAME_MESSAGE);
        checkArgument(name.length() <= MAX_NAME_LENGTH, NAME_LENGTH_MESSAGE, MAX_NAME_LENGTH);

        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String print() {
        return String.format("%-" + MAX_NAME_LENGTH + "s", name);
    }
}
