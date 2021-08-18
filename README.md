# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 1단계 - 자바8 스트림, 람다, Optional
### 람다(lambda)
* 람다와 클로저  
    >람다는 익명 함수의 다른 표현이다. 즉, 함수는 함수인데 이름이 없는 경우를 의미한다.

### 스트림(stream)
* map, filter, reduce  
    > Collection에 담긴 데이터를 처리하려면 Collection을 순회하면서 각 Element를 처리하는 것이 일반적이다. 앞으로는 순회하는 것을 잊고, Element 처리에만 집중하자.
* sorted() 정렬  
    >.sorted(Comparator.comparing(String::length)) => 글자 길이 비교해서 정렬(길이가 짧 -> 길 정렬)
    .sorted(Comparator.comparing(String::length).reversed()) => 글자 길이 비교해서 정렬 역순
* distinct() 중복제거