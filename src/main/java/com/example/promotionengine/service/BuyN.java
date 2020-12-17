package com.example.promotionengine.service;

import com.example.promotionengine.models.Cart;
import com.example.promotionengine.models.Item;
import com.example.promotionengine.models.ItemPrice;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BuyN implements PromotionEngine {
    Item item;
    int quantity;
    int offerPrice;

    @Override
    public int totalAfterPromotion(Cart cart, ItemPrice itemPrice) {
        return cart.
    }
}
