package com.ksnote.jpastudy.entity;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Chapter06Test {

    @Test
    void 카테고리_등록() {
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
        Category category1 = Category.builder()
                .name("category1")
                .build();
        em.persist(category1);


        for (int i = 1; i <= 10; i++) {
            Item item = Item.builder()
                    .name("item" + i)
                    .price(i * 1000)
                    .stockQuantity(i * 10)
                    .build();
            em.persist(item);
        }

        em.clear();
    }
}
