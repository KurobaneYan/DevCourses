package com.netcracker.sd4.persistence.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Car.class)
public abstract class Car_ {

	public static volatile SingularAttribute<Car, Integer> amountLeft;
	public static volatile SingularAttribute<Car, Integer> price;
	public static volatile SingularAttribute<Car, String> bodyStyle;
	public static volatile SingularAttribute<Car, String> model;
	public static volatile SetAttribute<Car, CarInOrder> carsInOrder;
	public static volatile SingularAttribute<Car, Integer> id;
	public static volatile SingularAttribute<Car, Integer> productionYear;
	public static volatile SingularAttribute<Car, String> manufacturer;

}

