package pill.health.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pill.health.dto.MemberFormDto;
import pill.health.entity.member.Member;
import pill.health.repository.MemberRepository;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void save(MemberFormDto memberForm) {
        Member newMember = new Member(
                memberForm.getUsername(),
                memberForm.getName(),
                memberForm.getPassword(),
                memberForm.getPrivateNumber(),
                memberForm.getAddress(),
                memberForm.getTell(),
                memberForm.getEmail()
        );
        memberRepository.save(newMember);
    }

    @Transactional
    public void delete(Member member) {
        memberRepository.delete(member);
    }

}
