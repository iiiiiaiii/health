package pill.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pill.health.entity.member.Member;

import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, UUID> {

    Optional<Member> findByUsername(String username);
}
