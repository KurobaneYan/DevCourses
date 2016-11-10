package com.netcracker.sd4.persistence.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CarInOrder.class)
public abstract class CarInOrder_ {

	public static volatile SingularAttribute<CarInOrder, Integer> amount;
	public static volatile SingularAttribute<CarInOrder, Order> orderByFkOrder;
	public static volatile SingularAttribute<CarInOrder, Car> carByFkCar;
	public static volatile SingularAttribute<CarInOrder, Integer> id;

}

