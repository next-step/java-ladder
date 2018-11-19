import java.util.Arrays;

public class Person {
    private final String DELIMETER=",";
    private String[] persons;

    public Person(String persons) throws Exception {
        this.persons = persons.split(DELIMETER);
        for (String name : this.persons) {
            if (name.length() > 5) {
                throw new Exception();
            }
        }
    }
    public int getCount(){
        return persons.length;
    }

    @Override
    public String toString() {
        StringBuilder nameString = new StringBuilder();
        Arrays.stream(persons).forEach(person -> nameString.append(person).append(" "));
        return nameString.toString();

    }
}
