package ladder.domain;

public class ResultPrize {

    private final String personName;
    private final String prizeValue;

    private ResultPrize(String personName, String prizeValue) {
        this.personName = personName;
        this.prizeValue = prizeValue;
    }

    public static ResultPrize of(String personName, String prizeValue) {
        return new ResultPrize(personName, prizeValue);
    }

    public String getPersonName() {
        return personName;
    }

    public String getPrizeValue() {
        return prizeValue;
    }

    public boolean checkEqaulName(String resultName) {
        return personName.equals(resultName);
    }
}
