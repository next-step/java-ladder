# 2단계 - 사다리(생성)

## 분석
### domain

####  예외처리
- OutOfNameLengthException
- NotAPositiveStepsOfLadderException
- InvalidCountOfParticipantsException

#### utils

#### Participants
- ParticipantName 참여자 이름
    - private Name(String name)
    - public static Name of(String name)
    - private validate 0 ~ 5 자 인지 검사 -> OutOfNameLengthException
    - @Override toString 
    
- Participant 참여자
    - ParticipantName
    - @Override toString 

- Participants 참여자들
    - private Participant(List<Participant> namesOfParticipants)
    - public static Participants of(String namesOfParticipants)
    - private static List<Participant> tokenizeNames
    - public Integer size()
    - private static String[] tokenizeNames(String names)
    - private static void validate(String[] nameTokens)
    - private static List<Participant> parseNames(String names)
    - public List<String> show()

#### Ladder 사다리
- interface PointStrategy
    - public static boolean hasPoint
- Point 좌표에 발판이 존재하는지에 대한 정보를 가지고 있다.
    - private final Boolean hasPoint
    - private Point(Boolean hasPoint)
    - public static Point of(Boolean hasPoint)

- Step 가로 라인 (참여자 수 - 1)
    - public static Step of(Integer countOfParticipants)
    - 좌표에 Point 가 있는지 boolean
    - private static hasPoint(Integer position, PointStrategy pointStrategy) 선을 생성할지 결정하는 함수
        - 첫 position -> 랜덤으로 결정 PointStrategy.hasPoint
        - position 의 이전 Point 검사 -> 이전에 Point 가 존재하면 false
        - position 의 이전 Point 검사 -> 이전에 Point 가 존재하지 않으면 랜덤으로 결정 PointStrategy.hasPoint
    - getStep (출력을 위한 기능)
- Steps 세로 라인 (사다리의 최대 높이)
    - private final List<Step> steps
    - private Steps(List<Step> steps)
    - public static Steps of(Integer countOfSteps) countOfSteps 만큼 step 생성
    - getSteps (출력을 위한 기능)
    - private void validate(Integer countOfSteps)사다리가 정수가 아니면 예외 처리

### view
- InputView
    - private InputView
    - readNamesOfParticipants 참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요) nextline
    - readCountOfSteps 최대 사다리 높이는 몇 개인가요? nextInt
    
- ResultView
    - private ResultView
    - printNamesOfParticipants 사다리를 출력할 때 사람 이름도 같이 출력한다.
    - printLadder 사다리 폭을 정할 수 있어야 한다. 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.

## 프로그래밍 요구사항
- 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
- 규칙 6: 모든 엔티티를 작게 유지한다.

## 실행 결과
위 요구사항에 따라 4명의 사람을 위한 5개 높이 사다리를 만들 경우, 프로그램을 실행한 결과는 다음과 같다.
```
참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
pobi,honux,crong,jk

최대 사다리 높이는 몇 개인가요?
5

실행결과

pobi  honux crong   jk
    |-----|     |-----|
    |     |-----|     |
    |-----|     |     |
    |     |-----|     |
    |-----|     |-----|
```


## 힌트
2차원 배열을 ArrayList, Generic 을 적용해 구현하면 ArrayList<ArrayList<Boolean>>와 같이 이해하기 어려운 코드가 추가된다.
사다리 게임에서 한 라인의 좌표 값을 가지는 객체를 추가해 구현해 본다.
public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line (int countOfPerson) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
    }

    [...]
}
위와 같이 Line 객체를 추가하면 ArrayList<ArrayList<Boolean>> 코드를 ArrayList<Line>과 같이 구현하는 것이 가능해 진다.

## 참고글
- [[if(kakao)2020] JUnit5를 시작하며](https://rutgo-letsgo.tistory.com/172)

## 생각
- 테스트 케이스 매개 변수를 실제 구현사항과 비슷하게 하기
- 테스트 케이스를 위해 private 이 아닌 protected 로 해보기
- private 메서드는 클래스로 분리할 수 있는지 생각해 보기
