package com.yuul.searching.model.internal;

import com.yuul.searching.model.external.GoogleGeometry.Viewport;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="advertisement")
public class Advertisement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int period;
    private String address;
    private BigDecimal price;
    //private Viewport viewport;

}
