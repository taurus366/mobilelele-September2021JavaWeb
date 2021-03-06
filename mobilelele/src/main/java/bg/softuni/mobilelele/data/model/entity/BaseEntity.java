package bg.softuni.mobilelele.data.model.entity;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




    @Column(nullable = false)
    private Instant created;

    private Instant modified;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    @PrePersist
    public  void beforeCreate() {
        this.created = Instant.now();
        System.out.println("PRE _______________________________");
    }

    @PostPersist
    public void onUpdate() {
        this.modified = Instant.now();
        System.out.println("POST ___________________________");
    }
}
