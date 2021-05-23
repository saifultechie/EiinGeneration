package com.eiin.institutionEiinGenerate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ActionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 6)
    private Action action;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private ModuleName moduleName;

    private Long documentId;
    private String ipAddress;
    private String comments;
}
