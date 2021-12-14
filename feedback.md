## STEP 2
### 1차 피드백
- 생성자가 아닌 팩토리 메소드에서 로직을 통한 생성은 괜찮은 것 같다.
- RandomLineStrategy 을 매번 생성하는 부분을 한 번 생성으로 변경
- view, util과 같은 생성자를 만들 필요가 없는 클래스는 private 생성자로 생성자가 생기는 걸 방지하기
```
같은 실수를 반복하지 말자..!
```
- static 메소드 경우 class명을 통해 람다 가능
```
this::lineFormat == ResultView::lineFormat
```
- 라인이 곂치지 않는지에 대한 테스트 작성

# STEP 3
### 질문
- while 문에 if 문을 없애고 싶은 데 방법이 있을까요?
[링크](https://github.com/next-step/java-ladder/pull/1268#discussion_r767640890)
```
저같은 경우는 while 문의 조건을 ALL 이 아닐 경우로 해서 미션을 진행했어요.
ALL 이 아니면 while 안에서 계속 사용자의 값을 입력받고 결과를 출력하도록 했습니다.
ALL 이 입력되는 순간 모든 사용자의 결과를 출력하기 때문에
더이상 프로그램이 실행될 필요가 없다고 생각해서 이런식으로 했었어요.
```
- Map 객체가 단지 view 에 보여주는 용도로만 사용 중인데, 일급 컬랙션으로 빼야 할까요?
[링크](https://github.com/next-step/java-ladder/pull/1268#discussion_r767676635)
```
개인적으로 일급 컬렉션을 만드는 기준은
해당 컬렉션이 담당할 비즈니스 로직이 있는지를 기준으로 하면 좋은거 같아요.

지금은 따로 만든다면 key 값이 있는지에 대한 validation 이나 join 하는 로직에 대한
처리 등을 담당 할 수 있을거 같은데 이부분은 자유롭게 하셔도 될거 같아요.
```

### 1차 피드백
- StringAsCategory, StringAsPlayers, AbstractInput, AbstractString 클래스 구조 변경
```
StringAs 같은 클래스를 클라이언트에서 사용할 경우
특정 메소드를 호출해야 한다는 점을 클라이언트가 알아야 된다는 문제점이 존재함.

추상클래스나 인터페이스 경우 클라이언트가 사용할 공통의 인터페이스를 위해 사용된다고 생각된다.
현재 사용 중인 추상클래스 경우 공통으로 처리하는 로직을 위해 존재하기 때문에 다른 방법으로
로직을 분리해보자.

제시해주신 방법
: 사용자의 입력 값을 validation하고, split 역할의 객체와
특정 일급 컬랙션을 생성하는 팩토리 메소드를 해당 클래스에서 만드는 방법.
```

- Category 사용 중이지 않는 것은 뭐든 제거하자!
```
private static final String DELIMITER = ",";
옮긴 코드 다시 보자 !
```

- Line 클래스의 get 메소드 - try-catch 부분
```
try-catch의 경우 throw를 하거나 다른 작업을 진행하는 용도로 사용된다.
리소스도 들어가기 때문에 if 문을 통해 파라미터를 체크해서 디폴트 값을 리턴해보자 !
```

- Item, Name 클래스의 역할이 없다.
```
맨 위 구조를 변경하면서 어떻게 할지 한 번 생각해보자 !
```

- LadderGame gamePlay메소드의 size
```
for문이 돌때마다 size를 호출하고 있기 때문에
따로 변수로 선언 후 사용하도록 하자.
```

- LadderGame 싱글톤 패턴의 단점
```
해당 클래스는 인스턴스가 없기 때문에
static 메소드로 생성하는 방법은 어떨까?

싱글톤의 단점을 살펴보자.
```
[싱글톤의 주의점](https://elfinlas.github.io/2019/09/23/java-singleton/)  
[싱글톤의 단점](https://mangkyu.tistory.com/153)

- ResultView.java ToJoining 
```
메소드명 시작을 대문자로 했다.
기본적인 건데 실수를 해버렸다. 다음부턴 조심하자.
```