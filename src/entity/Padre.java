package entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Padre {
    private Long id;
    private String nombrePadre;
    private String apellidoPadre;
    private Integer edadPadre;
    private List<Hijo> hijosById;
    private Documento documentoById;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre_padre")
    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    @Basic
    @Column(name = "apellido_padre")
    public String getApellidoPadre() {
        return apellidoPadre;
    }

    public void setApellidoPadre(String apellidoPadre) {
        this.apellidoPadre = apellidoPadre;
    }

    @Basic
    @Column(name = "edad_padre")
    public Integer getEdadPadre() {
        return edadPadre;
    }

    public void setEdadPadre(Integer edadPadre) {
        this.edadPadre = edadPadre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Padre padre = (Padre) o;
        return Objects.equals(id, padre.id) &&
                Objects.equals(nombrePadre, padre.nombrePadre) &&
                Objects.equals(apellidoPadre, padre.apellidoPadre) &&
                Objects.equals(edadPadre, padre.edadPadre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombrePadre, apellidoPadre, edadPadre);
    }

    @OneToMany(mappedBy = "padreByPadreId")
    public List<Hijo> getHijosById() {
        return hijosById;
    }

    public void setHijosById(List<Hijo> hijosById) {
        this.hijosById = hijosById;
    }

    @OneToOne(mappedBy = "padreById")
    public Documento getDocumentoById() {
        return documentoById;
    }

    public void setDocumentoById(Documento documentoById) {
        this.documentoById = documentoById;
    }
}
