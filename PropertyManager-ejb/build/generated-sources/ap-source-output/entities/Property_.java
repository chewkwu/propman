package entities;

import entities.Manager;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-17T16:09:59")
@StaticMetamodel(Property.class)
public class Property_ { 

    public static volatile SingularAttribute<Property, String> address;
    public static volatile SingularAttribute<Property, Manager> manager;
    public static volatile SingularAttribute<Property, Long> id;
    public static volatile SingularAttribute<Property, String> type;

}