package ladder;

public class Person {
    private static final int NAME_LIMIT_LENGTH = 5;

    private String name;

    private Person(String name) {
        validation(name);
        this.name = name;
    }

    public static Person of(String name) {
        return new Person(name);
    }

    private void validation(String name) {
        if(name.isEmpty() || name.length() > NAME_LIMIT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
