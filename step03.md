# 사다리 실행 결과를 출력

## step02 피드백
- Collections.unmodifiableList
- 중첩 forEach

## 기능 정의
### utils
- Tokenizer
    - public static List<String> tokenizeWithComma(String string)

### domain

예외처리
- OutOfNameLengthException
- NotAPositiveStepsOfLadderException
- InvalidCountOfNamesException
- InvalidPointsOfStepException
- DuplicatedNameException
- NotMatchedParticipantsWithNamesOfResultException

- Name 이름
    - private Name(String name)
    - public static Name of(String name)
    - private validate 0 ~ 5 자 인지 검사 -> OutOfNameLengthException
    - @Override toString 
    
- Names 
    - private final List<Name> names
    - private Names(List<Name> names)
    - public static Names of(String names)
    - private static List<String> tokenizeNames(String names)
    - private static void validate(List<String> nameTokens)
    - public void validateUnique() {
    - private static boolean isInValidCount(List<String> nameTokens)
    - private static List<Name> parseNames(String names)
    - public Integer size()
    - public List<String> getNames()
    
- Participants 참여자들

- NamesOfResult 

#### Ladder 사다리
- interface PointStrategy
    - public static boolean hasPoint
- Point 좌표에 발판이 존재하는지에 대한 정보를 가지고 있다.
    - private final Boolean hasLine
    - private Point(Boolean hasLine)
    - public static Point of(Boolean hasLine)
    - public Boolean hasLine() 출력을 위한 기능
    
- StepGenerator 
    - private StepGenerator(Integer countOfParticipants, PointStrategy pointStrategy)
    - public Step generate(); 
    - 같은 step 과 pointStrategy 를 요구하면 캐시하는 기능 고려

- Step 가로 라인 (참여자 수 - 1)
    - private Step(List<Point> points)
    - public static Step of(List<Boolean> points)
    - public static Step of(Integer countOfParticipants)
    - private static void validate(List<Point> points) points 가 유효한지 검사
    - private static initStep(Integer position, PointStrategy pointStrategy) 선을 생성할지 결정하는 함수
    - public List<Boolean> getPoints() 출력을 위한 기능
    
- Steps 세로 라인 (사다리의 최대 높이)
    - private final List<Step> ladder
    - private Steps(List<Step> ladder)
    - public static Steps of(Integer countOfSteps, StepGenerator stepGenerator) countOfSteps 만큼 step 생성
    - private void validate(Integer countOfSteps) 사다리가 정수가 아니면 예외 처리
    - public List<List<Boolean>> getSteps() 
    
    // - 참여자의 수와 같지 않으면 예외처리
    
- LadderGame 
    - 사다리(Steps)
    - NamesOfResult, NamesOfResult 을 인자로 받아 초기화함
    - NamesOfResult 과 NamesOfResult 의 길이가 같은지 검증
    - 사다리 높이와 stepGenerator 입력하면 사다리(Steps)를 만드는 메서드
    - 결과를 매칭하는 메서드
    
- Matcher
    - Steps 를 인자로 받아 결과를 인덱스로 출력

### view
- InputView
    - private InputView
    - public static String readNamesOfParticipants() 참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요) nextline
    - public static Integer readCountOfSteps()  최대 사다리 높이는 몇 개인가요? nextInt
    - 실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)
    - 결과를 보고 싶은 사람은? 
        - 참여자명단에 없으면 예외 처리
        - all 이 나올 때 까지 반복
    
- ResultView
    - private ResultView()
    - private static String padLeft(String string, Integer repeat)
    - public static void print(Participants participants, Steps ladder)
    - private static void printNamesOfParticipants(Participants participants)
    - private static void printLadder(Steps ladder) 
    - private static void printResults(...) 결과 목록 출력

### controller Main
- public static Participants readParticipants() 참여할 사람 입력 
- 실행 결과 입력
```
    실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)
    -> 실행 결과 목록을 저장하고 있는 객체 생성
        - 실행 결과 목록은 참여자 수와 같고 / 각 결과는 0 ~5 자 이어야 함, / ',' 로 구분 
```

- 사다리 높이 입력 및 출력
```
Integer heightOfLadder = InputView.readCountOfSteps();

StepGenerator stepGenerator = StepGenerator.of(participants, RandomPointStrategy.of());
Steps ladder = Steps.of(heightOfLadder, stepGenerator);
ResultView.print(participants, ladder);
```

- 결과를 보고 싶은 사람은? - 실행 결과
    - all 이 나올 때 까지 반복함
    - 이름이 참여자 명단에 포함되어있는지 검사
    - 이름과 매핑된 사다리 결과를 출력
    
- all 실행 결과
    - 매핑된 사다리 결과를 모두 출력
    


## 기능 요구사항
개인별 이름을 입력하면 개인별 결과를 출력하고, 
"all"을 입력하면 전체 참여자의 실행 결과를 출력한다.

## 프로그래밍 요구사항
자바 8의 스트림과 람다를 적용해 프로그래밍한다.

규칙 6: 모든 엔티티를 작게 유지한다.

규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.

## 실행 결과
위 요구사항에 따라 4명의 사람을 위한 5개 높이 사다리를 만들 경우, 
프로그램을 실행한 결과는 다음과 같다.

```
참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
pobi,honux,crong,jk

실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)
꽝,5000,꽝,3000

최대 사다리 높이는 몇 개인가요?
5

사다리 결과

pobi  honux crong   jk
    |-----|     |-----|
    |     |-----|     |
    |-----|     |     |
    |     |-----|     |
    |-----|     |-----|
꽝    5000  꽝    3000

결과를 보고 싶은 사람은?
pobi

실행 결과
꽝

결과를 보고 싶은 사람은?
all

실행 결과
pobi : 꽝
honux : 3000
crong : 꽝
jk : 5000
```
## 힌트
각 로직을 구현하기 위해 필요한 데이터를 가지는 객체를 분리하기 위해 노력해본다. 
로직 구현에 필요한 데이터를 가지는 객체를 잘 분리하면 의외로 쉽게 문제를 해결할 수 있다.

각 객체가 2개 이하의 인스턴스 변수만을 가지도록 구현해 본다.
