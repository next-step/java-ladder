# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

# Step01
##람다
    람다 실습 1 - 익명 클래스를 람다로 전환
        - 다음 테스트 코드에서 MoveStrategy에 대한 익명 클래스로 구현하고 있는데 람다를 적용해 구현한다.
    
    람다 실습 2 - 람다를 활용해 중복 제거
    

##스트림(stream)
    filter
    요구사항은 파일 문자 중 길이가 12보다 큰 문자의 수를 구한다.
    
    map
    List에 담긴 모든 숫자 값을 2배한 결과 List를 생성한다.
    
    reduce
    List에 담긴 모든 숫자의 합을 구한다.
    
    map, reduce, filter 실습 1
    List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합을 구한다. 지금까지 학습한 map, reduce, filter를 활용해 구현해야 한다.
    
    nextstep.fp.StreamStudyTest 클래스의 sumOverThreeAndDouble() 테스트를 pass해야 한다.

##Optional

    Optional을 활용해 조건에 따른 반환
    
    Optional에서 값을 반환
    
    Optional에서 exception 처리
