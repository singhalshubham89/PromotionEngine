package com.example.promotionengine.models;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ItemPrice {
    private Map<Item, Integer> itemPerUnitPrice;
}
