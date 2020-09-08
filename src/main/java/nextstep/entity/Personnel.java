package nextstep.entity;

public class Personnel {

    private final int personnel;

    private Personnel(int personnel) {
        this.personnel = personnel;
    }

    public int getPersonnel(){
        return personnel;
    }

    public static Personnel of(int personnel) {
        return new Personnel(personnel);
    }
}
