package com.example.promotionengine.models;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Cart {

    private Map<Item, Integer> itemsWithQuantity;

}
