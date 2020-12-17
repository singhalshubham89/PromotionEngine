package com.example.promotionengine.service;

import com.example.promotionengine.models.Cart;
import com.example.promotionengine.models.ItemPrice;

public interface PromotionEngine {
    int totalAfterPromotion(Cart cart, ItemPrice itemPrice);
}
