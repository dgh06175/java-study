# 학습정리

### Collections.emptyList() vs new ArrayList()
https://velog.io/@ychxexn/Collections.emptyList-vs-new-ArrayList

5번 문제에서 미리 작성되어있던 Collections.emptyList()를 사용할때,
answer.add() 를 하면 오류가 난다.
이유는 Collections.emptyList() 는 final 타입 (상수) 이므로 변경이 불가능하기 때문이다.

그래서 객체의 값을 변경해야할 일이 있을 경우 new ArrayList()로 사용해야 한다.