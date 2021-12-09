package com.samjain.Shop.Controller

import com.samjain.Shop.Repo.ShopRepo
import com.samjain.Shop.Model.Shop
import com.samjain.Shop.Service.ShopService
import com.samjain.Shop.Configurations.ALL_STORES
import com.samjain.Shop.Configurations.STORE_BY_ID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.auditing.CurrentDateTimeProvider
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
//@RequestMapping("store-service/v1")
class StoreController {

    @Autowired
    lateinit var shopService: ShopService

    @Autowired
    lateinit var shopRepo: ShopRepo

    @PostMapping(ALL_STORES)
    fun save(@RequestBody shop: Shop):String{
        shop.createdAt = LocalDateTime.now()
        shop.lastUpdated = LocalDateTime.now()
        shopRepo.save(shop)
        return "Saved"
    }

    @GetMapping(ALL_STORES)
    fun getShop(@RequestParam(required = false)refDate:String?=null,@RequestParam(required = false)futureFlag:Boolean=false): List<Shop>{
        println("$refDate  $futureFlag")
        return shopService.getShops(refDate,futureFlag)
    }

    @GetMapping(STORE_BY_ID)
    fun getStoreById(@PathVariable shopId: Long): Any{

        return shopService.getShopById(shopId)

    }

}