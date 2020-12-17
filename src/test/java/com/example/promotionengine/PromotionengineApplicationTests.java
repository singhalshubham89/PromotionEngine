package com.example.promotionengine;

import com.example.promotionengine.models.Cart;
import com.example.promotionengine.models.Item;
import com.example.promotionengine.models.ItemPrice;
import com.example.promotionengine.service.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class PromotionengineApplicationTests {


    CartService cartService;

    @BeforeEach
    void contextLoads() {
        cartService = CartService.getCartServiceInstance();
    }

    @Test
    void cartPriceWithoutPromotion(){

        Item itemA = new Item('A');
        Item itemB = new Item('B');
        Item itemC = new Item('C');
        Item itemD = new Item('D');

        Map<Item, Integer> itemPerUnit = new HashMap<>();
        itemPerUnit.put(itemA, 50);
        itemPerUnit.put(itemB, 30);
        itemPerUnit.put(itemC, 20);
        itemPerUnit.put(itemD, 15);

        ItemPrice itemPrice = new ItemPrice(itemPerUnit);

        Map<Item, Integer> itemsWithQuantity = new HashMap<>();
        itemsWithQuantity.put(itemA, 1);
        itemsWithQuantity.put(itemB, 1);
        itemsWithQuantity.put(itemC, 1);

        Cart cart = new Cart(itemsWithQuantity);
        assert (cartService.getCartPrice(cart, itemPrice) == 100);


    }
}
