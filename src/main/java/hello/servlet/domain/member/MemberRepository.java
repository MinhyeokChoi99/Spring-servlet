package hello.servlet.domain.member;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 동시성 문제로 인해 실무에서는 ConcurrentHashMap이나 AtomicLong 사용을 고려
public class MemberRepository {

    private Map<Long, Member> store = new HashMap<>();
    private long sequence = 0L;

    @Getter
    private static final MemberRepository instance = new MemberRepository();

    private MemberRepository() {}

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
