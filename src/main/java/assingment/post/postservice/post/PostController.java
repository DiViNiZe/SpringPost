package assingment.post.postservice.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import assingment.post.postservice.user.User;
import assingment.post.postservice.user.UserService;

@RestController
public class PostController {
  @Autowired
  private PostService postService;

  @Autowired 
  private UserService userService;


  @GetMapping("/post")
  public ResponseEntity<List<Post>> getAllPostList() {
    List<Post> post = postService.getAllPost();
    post.forEach(p -> {
      long pid = p.getUser().getId();
      p.setUser(userService.getUserById(pid));
    });
    return new ResponseEntity<>(post,HttpStatus.OK);
  }


  @PostMapping("/post/{userId}")
  public ResponseEntity<Post> postNewPost(@PathVariable long userId,@RequestBody Post post) {
    User user = userService.getUserById(userId);
    post.setUser(user);
    postService.savePost(post);
    return new ResponseEntity<Post>(post,HttpStatus.OK);
  }

  @DeleteMapping("/post/{id}")
  public ResponseEntity<Long> deletePost(@PathVariable Long id) {
    postService.deletePost(id);
    return new ResponseEntity<Long>(id,HttpStatus.OK);
  }

  
}