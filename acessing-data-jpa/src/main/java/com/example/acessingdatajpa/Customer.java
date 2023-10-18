package com.example.acessingdatajpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    
    @Id // Indica a chave primária
    @GeneratedValue(strategy = GenerationType.AUTO) // Indica que o valor vai ser gerado pelo próprio banco de dados, sendo o AUTO definido pelo Driver de acesso do H2
    // OBS: Importante verificar se o driver de acesso possui o AUTO
    // Identity - Servidores SQL que tem esse tipo no banco de dados
    // Sequence - Servidores Oracle que possuem esse tipo no namco
    // Table - Guarda os valores alto gerados
    // UUID - Um hash que possui uma sequência de valores enorme
    private long id;
    private String firrtName;
    private String lastName;

    // Não permitindo chamar esse construtor sendo um programador, permitindo apenas que o JPA o chame
    protected Customer(){}

    public Customer(String firstName, String lastName) {
        this.firrtName = firstName;
        this.lastName = lastName;
    }

    // Escritas dos Atributos
    public long getId() {
        return id;
    }

    public String getFirrtName() {
        return firrtName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", firstName=" + firrtName + ", lastName=" + lastName + "]";
    }

    
}
