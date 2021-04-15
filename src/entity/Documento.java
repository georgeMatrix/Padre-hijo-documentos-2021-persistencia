package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Documento {
    private Long id;
    private String curp;
    private String rfc;
    private Padre padreById;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "curp")
    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    @Basic
    @Column(name = "rfc")
    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Documento documento = (Documento) o;
        return Objects.equals(id, documento.id) &&
                Objects.equals(curp, documento.curp) &&
                Objects.equals(rfc, documento.rfc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, curp, rfc);
    }

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    public Padre getPadreById() {
        return padreById;
    }

    public void setPadreById(Padre padreById) {
        this.padreById = padreById;
    }
}
