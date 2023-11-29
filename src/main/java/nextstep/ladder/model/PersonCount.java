package nextstep.ladder.model;

public class PersonCount {

    private final Integer countOfPerson;

    public PersonCount(Integer countOfPerson) {
        validateCountOfPerson(countOfPerson);
        this.countOfPerson = countOfPerson;
    }

    private void validateCountOfPerson(Integer countOfPerson) {
        if (countOfPerson < 0) {
            throw new IllegalArgumentException("사람의 수는 1 이상 이어야 합니다.");
        }
    }

    public Integer getCountOfPerson() {
        return countOfPerson;
    }
}
