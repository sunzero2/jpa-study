package com.jpa.study.join;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
    static EntityManager em = emf.createEntityManager();

    public void noMapping() {
        Member m1 = new Member("member1", "회원1");
        Member m2 = new Member("member2", "회원2");
        Team t1 = new Team("team1", "팀1");

        m1.setTeam(t1);
        m2.setTeam(t1);

        Team findTeam = m1.getTeam();
    }

    public void testSave() {
        Team team1 = new Team("team1", "팀1");
        em.persist(team1);

        Member member1 = new Member("member1", "회원1");
        member1.setTeam(team1);
        em.persist(member1);

        Member member2 = new Member("member1", "회원1");
        member2.setTeam(team1);
        em.persist(member2);
    }

    public void testGet() {
        // 1. 객체 그래프 탐색
        Member member = em.find(Member.class, "member1");
        // member와 관련된 team 엔티티 조회 가능
        Team team = member.getTeam();

        // 2. 객체지향 쿼리 사용
        String jpql = "select m from Member m join m.team t where t.name = :teamName";
        List<Member> resultList = em.createQuery(jpql, Member.class).setParameter("teamName", "팀1").getResultList();

        for (Member m : resultList) {
            System.out.println(member.getUsername());
        }
    }
}
