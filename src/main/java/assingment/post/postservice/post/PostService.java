package assingment.post.postservice.post;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  @Autowired
  private PostRepository postRepository;

  public List<Post> getAllPost(){
    return  postRepository.findAll();
  }

  public List<Post> getPostByUser(long id){
    return postRepository.findByUserId(id);
  }

  public Post getPostById(long id){
    return postRepository.getOne(id);
  }

  public void savePost(Post post){
    postRepository.save(post);
  }

  public void deletePost(long id){
    postRepository.deleteById(id);
  }

  public Post getPostWithUser(){
    return null;
  }

  
}