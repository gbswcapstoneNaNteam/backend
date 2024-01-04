package gbsw.example.capstone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "daetree")
public class Daetree {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int code;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String wirtetime;

    @Column
    private String password;

    @Column
    private String name;
}//DaeTree테이블
