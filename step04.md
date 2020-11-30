## 피드백
- Collections.unmodifiableList() 활용
- 네이밍 좀 더 신경쓰기
- 빌더 패턴의 단점이라고 하면 .build()를 호출하는순간 객체 생성이 완료되는 구조이기에 완성되지 않은
  객체를 누군가 사용할 수 있다는 점인 것 같아요! 그렇기에 해당 리뷰를 드리면서 build()가 되기까지 term이 존재하여 구성 과정에서 일관성이 없는 상태에서 사용될 수 있다는 단점
- `!target.equals("all")` equals 를 쓸 때 메서드 대상이 null 이 아닌지 확인
- 해당 Ladder 객체를 은영님이 아닌 동료가 사용할 경우 List<List<Boolean>> 라는 반환값은
  어떤 값을 의미하는지 헷갈릴 것 같아요 😄
- 사다리 결과를 객체로 분리 private final List<Integer> resultTable;
- if 문의 내부가 한 문장일 경우에도 중괄호로 둘러싸는게 컨벤션
- DisplayName 의 목적은 테스트 클래스 또는 테스트 방법에 대한 값이나 설명을 선언하는 데 사용되는것이 목적이기에 기능 정의는 DisplayName 이 아닌 별도로 정의해주시면 어떨까 합니다..!!

## thinking
저번시간에 실수했던것 -> 출력을 위한 get 을 기능을 구현하는용도로도 사용을 해 버렸다. 오직 출력을 위한 get 을 만드는 방법이 없을까?


## 기능 정의

### 이름 관련 클래스들
- Name
    - 이름을 가지고 있다.
    - 이름의 길이는 1 ~ 5자 인지 검사하는 기능
    - 금지어인지 검사하는 기능
    - 출력을 위해 name 을 toString Override
    
- Names
    - List<Name> 을 가지고 있다.
    - 생성자인자 String 으로 입력받은 이름들을 토큰화 하는 기능
    - 생성자인자 String 으로 입력받은 이름들이 2개 이상인지 검사하는 기능
    - 중복된 이름을 가지고 있는지 검사하는 기능
    - List<Name> 의 사이즈를 반환하는 기능
    - 출력을 위해 List<Name> 를 반환하는 기능
    
- NamesOfResult
    - Names 를 가진다
    - String 으로 이름들을 생성자의 인자로 받는 기능
    - 출력을 위해 List<Name> 를 반환하는 기능
    - List<Name> 의 사이즈를 반환하는 기능
    
- NamesOfParticipant
    - Names 를 가진다
    - 생성자
        - 인자  String 이름들
        - Names의 인자 이름들이 unique 한지 검사하는 기능 호출
        - Names의 인자 이름들이 금지어를 가지는지 검사하는 기능 호출
    - 출력을 위해 List<Name> 를 반환하는 기능
    - List<Name> 의 사이즈를 반환하는 기능
    - Name 을 인자로 받아 Name 의 인덱스를 반환하는 기능

### 사다리 관련 클래스들
- Point
    - 사다리의 좌표를 의미함
    - Boolean 으로 좌표에 Line(발판) 이 있는지 멤버변수를 가짐
    - 출력을 위해 좌표에 발판이 있는지를 반환하는 기능
- Step 
    - 사다리의 한 단계 단위를 의미함
    - 사다리의 높이가 5 라면 각각의 1를 의미
    - 사다리 한 단계에 List<Point> 가로 좌표들을 가짐
    - (참여자 수 - 1) 만큼, 사다리 한 단계의 좌표가 line(발판) 을 가지는지 랜덤으로 배정하여 Step 을 초기화 하는 기능
    - List<Point> 가 유효하게 배정되었는지 검사하는 기능 true-true 가 연속으로 존재하면 에러 던짐
    - 출력을 위한 List<Point> 를 리턴하는 기능
    
- Ladder
    - 생성자
        - 사다리의 높이, 참여자의 수, PointStrategy 을 인자로 받음
    - List<Step> 를 멤버 변수로 가짐
    - List<Step> 을 초기화 하는 기능
    - 사다리 높이가 1보다 작을 때 예외 던짐
    - 출력을 위해 List<Step> 를 리턴하는 기능
    - 사다리의 높이를 반환하는 기능
        
- TableOfResult
    - 사다리타기 게임의 매핑 결과를 가지고 있는 클래스
    - List<Integer>
    - List 의 사이즈는 참여자의 수와 같다.
    - 각 인덱스가 의미하는 것은, 
        - 0 인덱스에 3 라는 참여자가 저장되어 있다면, 
        - 0번째 NamesOfResult 에 당첨자가 NameOfParticipant 의 3번째 참여자 이다
    - 사다리 게임 매핑결과를 Integer 로 가지고 있는 이유는, 
    결과가 주어진 사다리 게임 상에서 결과와 참여자 이름을 바꿀수 있어야 한다고 생각했기 때문이다.
    - 사다리를 생성자 인자로 받아 매핑 결과를 초기화 한다.
    - participant 의 position 을 바꾸는 기능
    - 설명을 길게 적은 것을 보면 한눈에 역할을 알기 어려운 클래스 인것 같기도하다 
    
- MatcherOfResult
    - NamesOfParticipant, NamesOfResult, TableOfResult 을 Builder 의 인자로 받아 생성한다.
    - 참여자 이름을 인자로 받아 결과를 리턴하는 기능
    - 모든 매칭 결과를 map 으로 리턴하는 기능

    
        

