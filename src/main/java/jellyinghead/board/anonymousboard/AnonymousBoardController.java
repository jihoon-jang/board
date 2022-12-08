package jellyinghead.board.anonymousboard;

import jellyinghead.board.anonymousboard.model.AnonymousPost;
import jellyinghead.board.common.model.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class AnonymousBoardController {

    final AnonymousService anonymousService;

    @GetMapping("/anonymous-posts/{post_id}")
    public ModelAndView getAnonymousPost(@PathVariable("post_id") int postId) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/anonymous_board/post");
        mav.addObject("anonymousPost", anonymousService.getAnonymousPost(postId));
        return mav;
    }

    @GetMapping("/anonymous-posts")
    public ModelAndView getAnonymousPosts(
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC, size = 20) Pageable pageable) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/anonymous_board/list");
        mav.addObject("anonymousPosts", anonymousService.getAnonymousPosts(pageable));
        return mav;
    }

    @PostMapping("/anonymous-post")
    public ResponseEntity<Result<AnonymousPost>> postAnonymousPost(@RequestBody AnonymousPost anonymousPost) {
        return ResponseEntity.ok(Result.create(anonymousService.addAnonymousPost(anonymousPost)));
    }

}
