import java.util.Arrays;

public class Person {
    private static final String DELIMETER=",";
    private static final int MAX_NAME_LENGTH=5;
    private String[] persons;


    public Person(String persons) throws Exception {
        this.persons = persons.split(DELIMETER);

        for (String name : this.persons) {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new Exception();
            }
        }
    }
    public int personCounts(){
        return persons.length;
    }

    @Override
    public String toString() {
        StringBuilder nameString = new StringBuilder();
        Arrays.stream(persons).forEach(person -> nameString.append(person).append(" "));
        return nameString.toString();

    }
}