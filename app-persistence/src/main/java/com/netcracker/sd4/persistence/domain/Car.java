package com.netcracker.sd4.persistence.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "car")
public class Car {
    private int id;
    private int productionYear;
    private int price;
    private int amountLeft;
    private String model;
    private String manufacturer;
    private String bodyStyle;
    private List<CarInOrder> carsInOrder;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "production_year")
    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "amount_left")
    public int getAmountLeft() {
        return amountLeft;
    }

    public void setAmountLeft(int amountLeft) {
        this.amountLeft = amountLeft;
    }

    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Basic
    @Column(name = "body_style")
    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (productionYear != car.productionYear) return false;
        if (price != car.price) return false;
        if (amountLeft != car.amountLeft) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        if (manufacturer != null ? !manufacturer.equals(car.manufacturer) : car.manufacturer != null) return false;
        if (bodyStyle != null ? !bodyStyle.equals(car.bodyStyle) : car.bodyStyle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + productionYear;
        result = 31 * result + price;
        result = 31 * result + amountLeft;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (bodyStyle != null ? bodyStyle.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "car")
    public List<CarInOrder> getCarsInOrder() {
        return carsInOrder;
    }

    public void setCarsInOrder(List<CarInOrder> carsInOrder) {
        this.carsInOrder = carsInOrder;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", productionYear=" + productionYear +
                ", price=" + price +
                ", amountLeft=" + amountLeft +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", bodyStyle='" + bodyStyle + '\'' +
                '}';
    }
}
