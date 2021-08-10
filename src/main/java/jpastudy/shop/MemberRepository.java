package jpastudy.shop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//자동으로 spring bean에 등록된다.
@Repository
public class MemberRepository {

    @PersistenceContext //entity 매니저를 주입을 해준다.
    private EntityManager em;

    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id){
        return em.find(Member.class, id);
    }


}
