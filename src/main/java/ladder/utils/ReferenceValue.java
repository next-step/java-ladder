package ladder.utils;

public enum ReferenceValue {

    NAME_LENGTH(5);

    private int nameLength;

    ReferenceValue(int nameLength) {
        this.nameLength = nameLength;
    }

    public boolean isInValidNameLength(String name){
        return name.length() > this.nameLength;
    }

}
