package com.example.promotionengine.service;

import com.example.promotionengine.models.Cart;
import com.example.promotionengine.models.Item;
import com.example.promotionengine.models.ItemPrice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Buy2ItemPromotion implements Promotion{
    Item offerItemA;
    Item offerItemB;
    int offerPrice;

    @Override
    public int priceDeductedAfterPromotion(Cart cart, ItemPrice itemPrice) {
        if(cart.getItemsWithQuantity().containsKey(offerItemA) &&cart.getItemsWithQuantity().containsKey(offerItemB)) {
            int eligibleLot = Integer.min(cart.getItemsWithQuantity().get(offerItemA),
                    cart.getItemsWithQuantity().get(offerItemA));
            return (eligibleLot*itemPrice.getItemPerUnitPrice().get(offerItemA)) +
                    (eligibleLot*itemPrice.getItemPerUnitPrice().get(offerItemB)) - (eligibleLot*offerPrice);
        }
        else
            return 0;
    }
}
