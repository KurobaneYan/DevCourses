package com.netcracker.sd4.persistence.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, Integer> date;
	public static volatile SingularAttribute<Order, Integer> cast;
	public static volatile SetAttribute<Order, CarInOrder> carInOrdersById;
	public static volatile SingularAttribute<Order, Integer> id;
	public static volatile SingularAttribute<Order, User> userByFkUser;

}

