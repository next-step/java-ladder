# 사다리 게임

## PR 링크 정리
- step1 : https://github.com/next-step/java-ladder/pull/1680
- step2 : https://github.com/next-step/java-ladder/pull/1790
- step3 : https://github.com/next-step/java-ladder/pull/1868
- step4 : null

## 진행 방법

* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## STEP 1 학습테스트 & 요구사항 체크리스트

- [x] lambda 실습 1 : MoveStrategy에 대한 익명 클래스로 구현하고 있는데 람다를 적용
- [x] lambda 실습 2 : 3보다 큰 수만을 더하는 로직구현, 중복코드 제거
- [x] map, reduce, filter 실습 1 : List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합을 구한다
- [x] map, reduce, filter 실습 2 : printLongestWordTop100() 메서드를 구현
- [x] Optional 실습1 : 조건에 따른 반환
- [x] Optional 실습2 : 값을 반환
- [x] Optional 실습3 : exception 처리

## STEP2

### TDD 진행에 관하여

- 한방에 모든 테스트를 작성하고 개발할수가 없다. 전체 요구사항을 잘게 쪼개서
- 설계 >> RED Test >> 구현 >> Green Test >> 리팩토링 :: 해당 과정들을 짧은 주기로 여러번 반복해서 진행하였습니다


## 구현관련 
- 목적이 있는 테스트코드
  - 주제 : 모든 테스트코드에는 "테스트 대상" 과 "테스트코드의 의도 & 목적" 을 잘 드러내기 위해 노력했습니다
  - 왜냐하면 : 테스트코드에는 "무엇을 테스트하고자 하는지" 에 대한 정보가 들어있어야 한다고 생각하기 때문입니다
  - 노력한 부분은 : 필수요소가 아닌 juit::as() 메서드를 활용하고, @DisplayName 등의 메서드를 활용하였습니다.

- CrossIntersection 방지 로직 적용
  - 주제 : 미션의 요구사항으로는 존재하는 `사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다` 기능
  - `|-----|-----|` 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없기때문에 해당 케이스는 발생하지 않도록 구현

- Preferences 개념 도입
  - 주제 : 사다리 최대 높이(Max Column) 사다리 최대 너비(Max Row) 등에 대한 설정을 Preferences 클래스에서 통합하여 관리하게 만들었습니다.


## 이외
- 지난번 Step1 리뷰에서 추가 코멘트 주신 부분이 두가지 있었는데요
```text
Lambda 학습테스트에서의 의도를 잘못 파악한 부분
StreamStudy 클래스에서의 중복 제거 (File 에 저장되어있는 Dataset Loading 부분)
```
- 위 2가지 사항에 대해서 수정반영 했습니다

## 추가학습 - 이펙티브 자바 아이템28 배열보다는 리스트를 사용하라

- 배열보다 리스트를 사용하는것을 추천하는데 이유
```text

```

### 배열보다 리스트를 사용해야하는 이유 : 공변과 불공변 개념
- 배열 사용시에는 아래의 코드가 Compile Time 에는 문제없으나, Runtime 에 Exception 이 발생한다 
```text
Object[] objectArray = new Long[1];
objectArray[0] = "문자열 저장에 실패하는 코드"; //ArrayStoreException을 던진다.
```
- 반면 리스트 사용시에는 컴파일타임에 문제가 발생한다.
```text
List<Object> objects = new ArrayList<Long>(); // 컴파일 에러 발생
o1.add("실행조차 되지 않음");
```
- 공변과 불공변 개념으로 인해 
- Object 는 Long 의 상위 타입
- Object[] 는 Long[] 의 상위 타입으로 인식함. 이를 `공변(covariant)` 이라고  
- List<Object>은 List<Long>의 하위 타입도 아니고 상위 타입도 아니다. 왜냐하면 제네릭이 `불공변(contravariant)`이기 때문

### 정말 배열이 하나도 메리트가 없을까?
- List 의 구현체에 따라 상황이 많이 달라질수 있을꺼같아서 `Array VS ArrayList` 상황만을 상정한다면
- 타입안정성, 오류검출 시점 이라는 두가지 관점에서 배열은 나쁜 선택지인데, 다른장점은 없을까?
- 혹시 `시간복잡도` 혹은 `공간복잡도` 관점에서 이득볼수있지 않을까? 하는 생각으로 `ArrayList 구현코드`를 살펴봤다

```java
public class ArrayList<E> {
    
    transient Object[] elementData; // non-private to simplify nested class access
     
    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity);
        }
    }
}
```
- ArrayList 는 내부적으로 Object[] 을 사용하고 있었다. 
- 그렇다면 결론은 Array 나 ArrayList 나 시간복잡도, 공간복잡도는 완전히 동일함을 확인

### JDK 는 왜 Wrapper Class 에서 배열을 사용한걸까?
- Wrapper Class 인 `Long` 의 JDK 코드를 열어보면 (corretto 11.0.17 기준)
```java
private static class LongCache {
    private LongCache(){}

    static final Long cache[] = new Long[-(-128) + 127 + 1];

    static {
        for(int i = 0; i < cache.length; i++)
            cache[i] = new Long(i - 128);
    }
}
```
- 공간 & 시간 복잡도를 동시에 줄이기 위해 자주 사용되는 범위의 인스턴스를 미리 생성해두는데 왜 배열을 사용한걸까??
- List 구현을 포함한 JCF도 JDK 에 포함되기 때문에 외부 클래스 의존성을 최소화하기 위함이 아니였을까..? 라고 추측해봤는데요
- 한문장으로 제 결론을 정리해보면 
```
DIP 를 지키기 위해서 JDK 에서 lang 패키지의 Long 클래스가, util 패키지의 ArrayList 에 의존성이 생기지 않게 하기 위해 어쩔수 없이 배열을 사용했다고 생각합니다.
왜냐하면 자신보다 변하기 쉬운것에 의존성이 생기면 안되니까요
```

### 결론 JDK 개발자 말고 나같은 App 개발자들은 배열을 쓰면 안되는걸까?
- 제 생각에는 99.9%는 그런거같습니다. 왜냐하면 득보다 실이 많기 때문인데요
- 외부에서의 요구조건 혹은 반환타입이 명시적으로 Array Type 이 아닌경우에는 List 를 사용하는게 아래의 장점을 가지고 있습니다
```text
stream 사용 가능
타입 안정성 (타입에러를 컴파일시점에 알수 있음 by 제네릭)

```
- 그럼에도 불구하고 0.1% 경우에 Array 를 써야만 하는 경우를 억지로 쥐어짜내보면 `극한의 성능`과 `Multi-Thread 환경에서 Thread-Safe 한 자료구조 필요` 상황이 있을꺼같은데
  - 극한의 성능이 필요하다 >> MIPS 가 높은 컴퓨터로 바꾸거나, 분산처리등의 아키텍쳐 적인 방법으로 처리한다
  - Multi-Thread 환경에서 Thread-Safe 한 자료구조 필요하다 >> SynchronizedCollection / Concurrent** 류의 자료구조를 사용
- 다른 방법으로 Workaround 가 충분히 가능하다고 생각해서.. 아마 `Array 는 웹 백엔드 개발 한정으로는 필요가.. 그닥?? 없을지도?? 모르겠다? 는 결론에 도달`했습니다

<br>
<br>
<br>

## Step3

### 요구사항 정리

#### 기능적 요구사항

- [x] 실행 결과를 입력받는다 (ex 꽝,5000,꽝,3000)
- [x] 사다리의 하단부에 결과를 배치해야한다
- [x] 결과를 보고싶은 개인의 이름을 입력하면 해당하는 결과를 출력한다
- [x] 결과 출력 상태에서 all 입력시 전체 참가자의 결과를 출력한다

#### 비기능적 요구사항

- [x] 데이터와 로직의 분리 : 각각의 기능을 로직을 구현하기 위해 필요한 데이터객체와 로직을 처리하는 클래스를 분리한다
- [ ] 모든 객체는 2개 이하의 인스턴스 변수만을 갖는다

#### 묵시적인 정책 정리

- [ ] 결과 출력은 두번 하고 자동으로 종료된다

#### 애매한거?
- [ ] 출력부분이 복잡한듯 Presenter, Renderer, Scene 정리필요 있음 >> @todo
