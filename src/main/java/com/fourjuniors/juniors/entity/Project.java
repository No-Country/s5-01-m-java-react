package com.fourjuniors.juniors.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "projectname")
    private String projectname;

    @Column(name = "projectdescription")
    private String projectdescription;

    @Column(name = "projectmembers")
    private String projectmembers;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "image", nullable = true)
    @Column(name = "image")
    private Image projectimage;

    @Column(name = "projectlinkrol")
    private String projectlinkrol;

    @Column(name = "projectlink")
    private String projectlink;

    @Column(name = "projectstack")
    private String projectstack;

    @Column(name = "projecttype")
    private String projecttype;
}
