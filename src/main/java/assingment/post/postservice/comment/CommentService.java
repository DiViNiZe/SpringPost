package assingment.post.postservice.comment;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assingment.post.postservice.post.Post;
import assingment.post.postservice.post.PostRepository;
import assingment.post.postservice.post.PostService;
import assingment.post.postservice.user.User;
import assingment.post.postservice.user.UserRepository;
import assingment.post.postservice.user.UserService;

@Service
public class CommentService {
  @Autowired 
  private CommentRepository commentRepository;

  @Autowired 
  private PostService postService;

  @Autowired 
  private UserService userService;

  public Comment createComment(@Valid Comment comment,long postId,long userId){
    Post post = postService.getPostById(postId);
    User user = userService.getUserById(userId);
    comment.setPost(post);
    comment.setUser(user);
    commentRepository.save(comment);
    return comment;
  }

  public List<Comment> getByPostId(long id){
    return commentRepository.findByPostId(id);
  }

}