package com.example.promotionengine.service;

import com.example.promotionengine.models.Cart;
import com.example.promotionengine.models.Item;
import com.example.promotionengine.models.ItemPrice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class BuyNPromotionService implements Promotion {
    Item item;
    int offerQuantity;
    int offerPrice;


    @Override
    public int priceDeductedAfterPromotion(Cart cart, ItemPrice itemPrice) {
        if(cart.getItemsWithQuantity().containsKey(item)){
            int itemQuantity =  cart.getItemsWithQuantity().get(item);
            int totalEligibleLot = (itemQuantity/offerQuantity);
            return  ((totalEligibleLot*offerQuantity*itemPrice.getItemPerUnitPrice().get(item))- (totalEligibleLot*offerPrice));
        }
        else{
            return 0;
        }
    }
}
