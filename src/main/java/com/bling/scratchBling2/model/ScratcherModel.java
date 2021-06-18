package com.bling.scratchBling2.model;

import org.w3c.dom.Text;

import javax.persistence.*;

@Entity
@Table(name = "ScratcherModel")
public class ScratcherModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public ScratcherModel() {

    }

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "sizes")
    private String[] sizes;

    @Column(name = "price")
    private double price;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getSizes() {
        return sizes;
    }

    public void setSizes(String[] sizes) {
        this.sizes = sizes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

   /* public ScratcherModel(String name, String description, String[] sizes, double price) {
        this.name = name;
        this.description = description;
        this.sizes = sizes;
        this.price = price;
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
