package com.samjain.Shop.Controller

import com.samjain.Shop.Repo.ShopRepo
import com.samjain.Shop.Model.Shop
import com.samjain.Shop.Service.ShopService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.auditing.CurrentDateTimeProvider
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("store-service/v1")
class StoreController {

    @Autowired
    lateinit var shopService: ShopService

    @Autowired
    lateinit var shopRepo: ShopRepo

    @PostMapping("/stores")
    fun save(@RequestBody shop: Shop):String{
        shop.createdAt = LocalDateTime.now()
        shop.lastUpdated = LocalDateTime.now()
        shopRepo.save(shop)
        return "Saved"
    }

    @GetMapping("/stores")
    fun getShop(): List<Shop>{
        return shopService.getShops()
    }

    @GetMapping("/stores/{shopId}")
    fun getStoreById(@PathVariable shopId: Long): Any{

        return shopService.getShopById(shopId)

    }

}