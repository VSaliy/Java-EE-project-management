package domen;

import domen.Zaposleni;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-04T22:01:02")
@StaticMetamodel(Mesto.class)
public class Mesto_ { 

    public static volatile SingularAttribute<Mesto, Integer> ptt;
    public static volatile SingularAttribute<Mesto, String> naziv;
    public static volatile CollectionAttribute<Mesto, Zaposleni> zaposleniCollection;

}