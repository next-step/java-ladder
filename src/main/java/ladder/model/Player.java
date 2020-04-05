package ladder.model;

import static ladder.Messages.WARNING_NOT_ALLOWED_NAME_LENGTH;

public class Player {
    private static final int NAME_MAX_LENGTH = 5;
    private static final int ZERO_LOCATION = 0;

    private String name;
    private int location;

    public Player(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public Player(String name, int location) {
        validateNameLength(name);
        this.name = name;
        this.location = location;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(WARNING_NOT_ALLOWED_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }

    public int findNextLocation(Row nextRow) {
        if(isFirstNow()){
            if(nextRow.getRowElement(location)){
                location = location + 1;
            }
            return location;
        }

        if(isLastNow(nextRow)){
            if(nextRow.getRowElement(location - 1)){
                location = location - 1;
            }
            return location;
        }

        if(!isFirstNow() && !isLastNow(nextRow)){
            if(nextRow.getRowElement(location)){
                location = location + 1;
            }
            if(nextRow.getRowElement(location - 1)){
                location = location -1;
            }
        }
        return location;
    }

    private boolean isFirstNow(){
        return location == ZERO_LOCATION;
    }

    private boolean isLastNow(Row nextRow){
        return location == nextRow.getLastLocationValue();
    }
}
