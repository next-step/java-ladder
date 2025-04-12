package nextstep.ladder.view;

public interface InputViewInterface {
    int getNumberInput(String prompt);

    String getStringInput(String prompt);

    String[] getStringListInput(String prompt, String delimiter);
}
