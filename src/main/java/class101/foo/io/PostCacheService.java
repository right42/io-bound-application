package class101.foo.io;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
public class PostCacheService {

    private Page<Post> firstPostPage;

    private final PostRepository postRepository;

    @Scheduled(cron = "* * * * * *")
    public void firstPostPageCaching(){
        firstPostPage = postRepository.findAll(PageRequest.of(0, 20));
    }

    public Page<Post> getFirstPostPage() {
        return this.firstPostPage;
    }
}
