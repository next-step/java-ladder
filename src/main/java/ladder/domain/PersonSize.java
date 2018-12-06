package ladder.domain;

public class PersonSize {

    private int size;

    public PersonSize(int sizeOfPeople) {
        this.size = sizeOfPeople;
    }

    public static PersonSize from(int sizeOfPeople) {
        return new PersonSize(sizeOfPeople);
    }

    public int size() {
        return size;
    }
}
