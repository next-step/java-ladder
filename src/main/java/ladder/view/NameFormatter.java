package ladder.view;

public interface NameFormatter<T> {
    int SPACE_FOR_NAME = 5;
    String BLANK_TO_FILL_THE_NAME_SPACE = " "; //TODO: 질문입니다. 인터페이스에 이런 상수들을 둬도 되는건지 궁금합니다.

    String nameFormat(T object);
}
