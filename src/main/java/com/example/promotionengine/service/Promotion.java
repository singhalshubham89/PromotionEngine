package com.example.promotionengine.service;

import com.example.promotionengine.models.Cart;
import com.example.promotionengine.models.ItemPrice;

public interface Promotion {
    int priceDeductedAfterPromotion(Cart cart, ItemPrice itemPrice);
}
