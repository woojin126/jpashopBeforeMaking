package hellojpa;

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


            tx.commit();



        }catch(Exception e){
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        }finally {
            em.close();//엔티티 매니저 종료
        }
    }
}
