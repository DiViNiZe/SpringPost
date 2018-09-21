package assingment.post.postservice.user;

import java.io.Serializable;
import java.util.Date;

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

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable{
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy =  GenerationType.IDENTITY)
  private long id;
  
  @NotBlank
    private String firstName;
    
    @NotBlank
    private String lastName;

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
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @param id the id to set
   */
  public void setId(long id) {
    this.id = id;
  }  

  @Override
  public String toString(){
    return firstName+" "+lastName;
  }
}