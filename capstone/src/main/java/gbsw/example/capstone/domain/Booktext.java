package gbsw.example.capstone.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Booktext {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int code;

    @Column
    private String text;



}//BookTest 테이블

