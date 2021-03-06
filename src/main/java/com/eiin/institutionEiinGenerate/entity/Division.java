package com.eiin.institutionEiinGenerate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String bn_name;
    private String url;
    @OneToMany(fetch = FetchType.EAGER)
    List<Eiin> eiin;
}
