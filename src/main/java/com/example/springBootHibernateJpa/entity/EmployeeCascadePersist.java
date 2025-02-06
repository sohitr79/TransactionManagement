package com.example.springBootHibernateJpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * Always make all packages as child of parent package that contaions application main
 * Since @SpringBootApplication this annotation contains @Component scan that will scan for any components
 * that are present either in this package or its child package
 */
@Entity
@Table(name = "emp")
@Getter
@Setter
@Data
public class EmployeeCascadePersist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    //.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory'
    // defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]:
    // Could not determine recommended JdbcType for `com.example.springBootHibernateJpa.entity.Department`
    //If we didn't include this we will get above error
    @ManyToOne(cascade = CascadeType.PERSIST) //CascadeType.PERSIST if there is any dept that's already not there
    //we will get error to fix this we can add this annotation this will save department as well
    @JoinColumn(name = "department_id", referencedColumnName = "departmentId")
    private Department department;
}
