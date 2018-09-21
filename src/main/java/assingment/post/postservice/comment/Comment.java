package assingment.post.postservice.comment;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import assingment.post.postservice.post.Post;
import assingment.post.postservice.user.User;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "comments")
public class Comment implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  
  @NotBlank
  private String content;
  
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name="posts_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonIgnore
  private Post post;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name="user_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private User user;

  @Column(nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  private Date createAt;

  /**
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * @return the createAt
   */
  public Date getCreateAt() {
    return createAt;
  }

  /**
   * @param createAt the createAt to set
   */
  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }

  /**
   * @return the user
   */
  public User getUser() {
    return user;
  }

  /**
   * @param user the user to set
   */
  public void setUser(User user) {
    this.user = user;
  }

  /**
   * @return the post
   */
  public Post getPost() {
    return post;
  }

  /**
   * @param post the post to set
   */
  public void setPost(Post post) {
    this.post = post;
  }

  /**
   * @return the content
   */
  public String getContent() {
    return content;
  }

  /**
   * @param content the content to set
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * @param id the id to set
   */
  public void setId(long id) {
    this.id = id;
  }
}
