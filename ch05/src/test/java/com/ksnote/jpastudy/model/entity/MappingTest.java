package com.ksnote.jpastudy.model.entity;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MappingTest {

    @Test
    void 주문한_회원_참조() {
        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpastudy");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {
            tx.begin(); //트랜잭션 시작
            logic(em);
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    private void logic(EntityManager em) {
        Member member = Member.builder().name("kks").build();
        em.persist(member);

        Order order = Order.builder().member(member).build();
        em.persist(order);

        Order findOrder = em.find(Order.class, order.getId());
        Member findMember = findOrder.getMember();

        assertThat(findMember).isEqualTo(member);

        em.remove(order);
        em.remove(member);
    }
}
