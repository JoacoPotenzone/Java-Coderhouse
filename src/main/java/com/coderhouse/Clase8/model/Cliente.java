package com.coderhouse.Clase8.model;
import jakarta.persistence.*;

@Entity
@Table(name="client")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastname;
    private String docnumber;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDocnumber() {
        return docnumber;
    }

    public void setDocnumber(String docnumber) {
        this.docnumber = docnumber;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", docnumber=" + docnumber +
                '}';
    }
    public void clienteValidado(String name, String surname, String docNumber) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("No puede estar vacío");
        }
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("No puede estar vacío");
        }
        try {
            Integer.parseInt(docNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El documento debe ser un numero");
        }
        this.name = name;
        this.lastname = surname;
        this.docnumber = docNumber;
    }
}
