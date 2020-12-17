package com.example.promotionengine.service;

import com.example.promotionengine.models.Cart;
import com.example.promotionengine.models.Item;
import com.example.promotionengine.models.ItemPrice;

import java.util.Map;


public class CartService {

    private static CartService cartService = null;

    public static CartService getCartServiceInstance(){
        if(cartService == null)
            cartService = new CartService();
        return cartService;
    }

    public int getCartPrice(Cart cart, ItemPrice itemPrice){

        int totalPriceWithoutPromotion = 0;
        for(Map.Entry<Item, Integer> cartItem: cart.getItemsWithQuantity().entrySet()){
            totalPriceWithoutPromotion =
                    totalPriceWithoutPromotion + (itemPrice.getItemPerUnitPrice().get(cartItem.getKey()))*(cartItem.getValue());
        }

        return totalPriceWithoutPromotion;

    }
}
