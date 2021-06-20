package hellojpa.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public abstract class Item extends BaseEntity { //아이템만 단독으로 테이블에 저장할일이 없으면 추상으로 만들어줘라

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    //카테고리와 양방향을위해 다대다
    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();


}