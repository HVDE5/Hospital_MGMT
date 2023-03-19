package ma.emsi.hospital.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean malade;
    private int score;

}
