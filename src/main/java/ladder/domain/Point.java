package ladder.domain;

public class Point {

    private boolean value;
    private Person person;

    public Point(boolean value, Person person) {
        this.value = value;
        this.person = person;
    }

    public boolean isValue() {
        return value;
    }

    @Override
    public String toString() {
        if (this.value) {
            return "-----|";
        }
        return "     |";
    }

    public boolean hasPerson(Person person) {
        return this.person.equals(person);
    }

    public Person getPerson() {
        return person;
    }
}
