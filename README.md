# jpashopBeforeMaking


각종 방향관계를 모두 써보자 
쇼핑몰 만들기전 어노테이션 및 구동 , 디비 만들어지는 형식 확인


### MakeFile 실행 설명

- 실행 파일 이름 jpaMain.java



### Entity 연결 관계

1.Member : Order   1 : 다 관계 || 양방향으로 설계 (관계의주인 Order)

2.Order : Delivery 1 : 1 관계 ||  (관계의주인 Order)

3.Order : OrderItem : Item || Order와 Item은 다 : 다 관계라  -> 1 : 다 : 1 로풀어냄 

4.Item : (Album ,Book, Movie) 상속 || @Inheritance(strategy = InheritanceType.SINGLE_TABLE) 싱글테이블 방식사용 

5. Category : Item 다 : 다 || 다 : 다 관계는 사용하지 않는것이 좋지만 공부용으로 
