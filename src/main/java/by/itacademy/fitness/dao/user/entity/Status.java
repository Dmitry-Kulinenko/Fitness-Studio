package by.itacademy.fitness.dao.user.entity;

import by.itacademy.fitness.dao.user.entity.userenum.StatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

@Entity
@Table(schema = "fitness", name = "user_status")
@JsonPropertyOrder({
        "status"
})
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    @JsonIgnore
    private int id;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum statusName;

    public Status() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StatusEnum getStatusName() {
        return statusName;
    }

    public void setStatusName(StatusEnum statusName) {
        this.statusName = statusName;
    }
}
