package hellojpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)//자식입장에서 부모가 하나
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    //내입장에서 자식 카테고리
    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    //item과 다대: 다 관계
    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM"
    ,joinColumns = @JoinColumn(name = "CATEGORY_ID"),
    inverseJoinColumns = @JoinColumn(name = "ITEM_ID")) //중간테이블로 형성되겠지?
    private List<Item> items = new ArrayList<>();
}
