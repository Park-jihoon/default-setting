package sample.pohinian.springvue.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Park Ji Hoon (pohinian@gmail.com) on 2018. 4. 16..
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
