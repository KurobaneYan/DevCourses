package com.netcracker.sd4.persistence.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.sql.Date;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, Date> date;
	public static volatile SingularAttribute<Order, Integer> cast;
	public static volatile ListAttribute<Order, CarInOrder> carsInOrder;
	public static volatile SingularAttribute<Order, Integer> id;
	public static volatile SingularAttribute<Order, User> user;

}

