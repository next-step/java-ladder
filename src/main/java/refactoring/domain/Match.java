package refactoring.domain;

public interface Match {

    void put(int position, String results);
    String getResult(int position);

}
