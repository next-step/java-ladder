package ladder.utils;

public enum ReferenceValue {

    NAME_LENGTH(5),
    LADDER_MINIMUM_USER(2);

    private int referenceValue;

    ReferenceValue(int referenceValue) {
        this.referenceValue = referenceValue;
    }

    public boolean isInValidLadderUserCount(int countOfPerson){
        return countOfPerson < this.referenceValue;
    }

    public boolean isInValidNameLength(String name) {
        return name.length() > this.referenceValue;
    }

}
