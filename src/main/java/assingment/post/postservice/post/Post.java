package assingment.post.postservice.post;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import assingment.post.postservice.comment.Comment;
import assingment.post.postservice.user.User;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "posts")
public class Post implements Serializable{

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    
    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "post")
    private List<Comment> comment;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createAt;


  /**
   * @return the user
   */
  public User getUser() {
    return user;
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
   * @return the comment
   */
  public List<Comment> getComment() {
    return comment;
  }

  /**
   * @param comment the comment to set
   */
  public void setComment(List<Comment> comment) {
    this.comment = comment;
  }

  /**
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * @param user the user to set
   */
  public void setUser(User user) {
    this.user = user;
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
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }
 
  
}