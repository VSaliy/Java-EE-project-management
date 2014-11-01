/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Damjan
 */
@Entity
@Table(name = "korisnik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Korisnik.countID", query = "SELECT count(k.korisnikID) FROM Korisnik k"),
    @NamedQuery(name = "Korisnik.findAll", query = "SELECT k FROM Korisnik k"),
    @NamedQuery(name = "Korisnik.findByKorisnikID", query = "SELECT k FROM Korisnik k WHERE k.korisnikID = :korisnikID"),
    @NamedQuery(name = "Korisnik.findByUsername", query = "SELECT k FROM Korisnik k WHERE k.username = :username"),
    @NamedQuery(name = "Korisnik.findByPassword", query = "SELECT k FROM Korisnik k WHERE k.password = :password"),
    @NamedQuery(name = "Korisnik.findByUsernameAndPassword", query = "SELECT k FROM Korisnik k WHERE k.username = :username AND k.password = :password")
})
public class Korisnik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "korisnikID", insertable = true, updatable = false)
    private Integer korisnikID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 6, max = 30)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "ime")
    private String ime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "prezime")
    private String prezime;
//     @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    @Column(name = "email")
    private String email;
    @Size(max = 225)
    @Column(name = "avatar")
    private String avatar;
    @Size(max = 225)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "korisnikID")
    private Collection<Projekat> projekatCollection;

    public Korisnik() {
        username = "";
        password = "";
        ime = "";
        prezime = "";
        email = "";
    }

    public Korisnik(Integer korisnikID) {
        this.korisnikID = korisnikID;
    }

    public Korisnik(Integer korisnikID, String username, String password, String ime, String prezime, String email) {
        this.korisnikID = korisnikID;
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }

    public Integer getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(Integer korisnikID) {
        this.korisnikID = korisnikID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Projekat> getProjekatCollection() {
        return projekatCollection;
    }

    public void setProjekatCollection(Collection<Projekat> projekatCollection) {
        this.projekatCollection = projekatCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (korisnikID != null ? korisnikID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Korisnik)) {
            return false;
        }
        Korisnik other = (Korisnik) object;
        if ((this.korisnikID == null && other.korisnikID != null) || (this.korisnikID != null && !this.korisnikID.equals(other.korisnikID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
}
