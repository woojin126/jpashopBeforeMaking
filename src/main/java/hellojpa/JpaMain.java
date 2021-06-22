package hellojpa;

import hellojpa.domain.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Slf4j
public class JpaMain {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{

            Member member = new Member();
            member.setName("김우진");
            member.setCity("미국");
            member.setStreet("신나무실");
            member.setZipcodes("집코드");
            em.persist(member);

            Delivery delivery = new Delivery();
            delivery.setCity(member.getCity());
            delivery.setStreet(member.getStreet());
            delivery.setZipcode(member.getZipcodes());

            Book book = new Book();
            book.setAuthor("인직");
            book.setName("그리움");
            em.persist(book);

            OrderItem orderItem = new OrderItem();
            orderItem.setItem(book);



            Order order = new Order();
            order.setCreateBy("날짜");
            order.setMember(member);
            order.setDelivery(delivery);
            order.addOrderItem(orderItem);

            em.persist(order);

            em.flush();
            em.clear();

           // Order order1 = em.find(Order.class, order.getId());

            System.out.println("-----------------------------");
            Order or = em.getReference(Order.class, order.getId());

            System.out.println("refInfo==" + or.getCreateBy());
            System.out.println("-----------------------------");
            tx.commit();

        }catch(Exception e){
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        }finally {
            em.close();//엔티티 매니저 종료
        }
    }
}
