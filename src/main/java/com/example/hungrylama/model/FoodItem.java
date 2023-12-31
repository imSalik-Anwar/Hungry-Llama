package com.example.hungrylama.model;

import com.example.hungrylama.Enum.FoodCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data // includes @getter, @setter, @toString and @reqArgConstructor
@Table(name = "food_item")
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    int Id;

    @Size(min = 1, max = 20)
    String dishName;

    double price;

    @Enumerated(EnumType.STRING)
    FoodCategory category;

    boolean veg;

    boolean available;

    // relations ================================================
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    Restaurant restaurant;

    @OneToMany(mappedBy = "foodItem", cascade = CascadeType.ALL)
    List<BasketItem> basketItemList = new ArrayList<>();
}
