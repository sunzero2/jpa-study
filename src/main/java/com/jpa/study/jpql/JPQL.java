package com.jpa.study.jpql;


import com.jpa.study.join.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class JPQL {
    @PersistenceContext
    private EntityManager em;

    public List<Member> findMembers() {
        // TypedQuery: 반환 타입을 명확하게 지정할 수 있을 때 사용
        TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m", Member.class);
        List<Member> resultList = query.getResultList();

        // 결과가 하나임이 보장될 때 사용. 반환 값이 없을 경우 NoResultException 발생. 1개보다 많으면 NonUniqueResultException 발생
        // Member resultObj = query.getSingleResult();

        // Query: 반환 타입을 명확하게 지정할 수 없을 때 사용
        Query query2 = em.createQuery("SELECT m.username, m.age FROM Member m");

        String jpql = "select m from Member as m where m.username = 'kim'";
        return em.createQuery(jpql, Member.class).getResultList();
    }

    public void findMemberByUsername(String username) {
        TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m WHERE m.username = :username", Member.class);
        query.setParameter("username", username);
        List<Member> members = query.getResultList();
    }

    public void findMembersWithPaging() {
        TypedQuery<Member> query = em.createQuery("SELECT m from Member m ORDER BY m.username DESC", Member.class);
        query.setFirstResult(10);
        query.setMaxResults(20);
        List<Member> members = query.getResultList();
    }
}
