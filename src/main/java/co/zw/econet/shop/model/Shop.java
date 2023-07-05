package co.zw.econet.shop.model;

import co.zw.econet.area.model.Area;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonBackReference
    @JoinColumn(name = "area_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Area area;
}
