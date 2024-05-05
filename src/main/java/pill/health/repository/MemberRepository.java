package pill.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pill.health.entity.member.Member;

import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, UUID> {
}
