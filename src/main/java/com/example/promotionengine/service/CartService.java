package com.example.promotionengine.service;

import com.example.promotionengine.models.Cart;
import com.example.promotionengine.models.Item;
import com.example.promotionengine.models.ItemPrice;

import java.util.ArrayList;
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


    public int getCartPriceWithPromotion(Cart cart, ItemPrice itemPrice, ArrayList<Promotion> promotions){
        int totalPrice = getCartPrice(cart, itemPrice);
        for(Promotion promotion: promotions){
            totalPrice = totalPrice - promotion.priceDeductedAfterPromotion(cart, itemPrice);
        }
        return totalPrice;
    }
}
