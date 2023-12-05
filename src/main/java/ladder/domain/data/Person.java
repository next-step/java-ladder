package ladder.domain.data;

public class Person {

    private final Name name;
    private final int order;

    public Person(String name) {
        this(name, 0);
    }

    public Person(String value, int order) {
        this.name = new Name(value);
        this.order = order;
    }

    public int order() {
        return order;
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Person person = (Person) object;

        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
