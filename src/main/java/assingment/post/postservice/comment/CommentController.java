package assingment.post.postservice.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

  @Autowired
  private CommentService commentService;
  

  @GetMapping("/comment/{postId}")
  public ResponseEntity<List<Comment>> getCommentByPostId(@PathVariable long postId){
    List<Comment> comment = commentService.getByPostId(postId);
    return new ResponseEntity<List<Comment>>(comment,HttpStatus.OK);
  }

  @PostMapping("/comment/{postId}/{userId}")
  public ResponseEntity<Comment> createComment(@PathVariable long postId,@PathVariable long userId,@RequestBody Comment comment){
    commentService.createComment(comment, postId, userId);
    return new ResponseEntity<Comment>(comment,HttpStatus.OK);
  }
}