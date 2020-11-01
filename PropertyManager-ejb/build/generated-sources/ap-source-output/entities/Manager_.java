package entities;

import entities.Property;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-17T16:09:59")
@StaticMetamodel(Manager.class)
public class Manager_ { 

    public static volatile SingularAttribute<Manager, String> Address;
    public static volatile SingularAttribute<Manager, String> phone;
    public static volatile SingularAttribute<Manager, String> name;
    public static volatile SingularAttribute<Manager, Long> id;
    public static volatile CollectionAttribute<Manager, Property> properties;

}