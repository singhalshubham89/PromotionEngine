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
    Map<Character, Item> items;
    ItemPrice itemPrice;

    @BeforeEach
    void contextLoads() {

        items = new HashMap<>();
        items.put('A', new Item('A'));
        items.put('B', new Item('B'));
        items.put('C', new Item('C'));
        items.put('D', new Item('D'));

        cartService = CartService.getCartServiceInstance();
        Map<Item, Integer> itemPerUnit = new HashMap<>();
        itemPerUnit.put(items.get('A'), 50);
        itemPerUnit.put(items.get('B'), 30);
        itemPerUnit.put(items.get('C'), 20);
        itemPerUnit.put(items.get('D'), 15);
        itemPrice = new ItemPrice(itemPerUnit);
    }

    @Test
    void cartPriceWithoutPromotion(){

        Map<Item, Integer> itemsWithQuantity = new HashMap<>();
        itemsWithQuantity.put(items.get('A'), 1);
        itemsWithQuantity.put(items.get('B'), 1);
        itemsWithQuantity.put(items.get('C'), 1);

        Cart cart = new Cart(itemsWithQuantity);
        assert (cartService.getCartPrice(cart, itemPrice) == 100);

    }
}
