package com.samjain.Shop.Service

import com.samjain.Shop.Model.Shop
import com.samjain.Shop.Repo.ShopRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShopService {
    @Autowired
    lateinit var shopRepo: ShopRepo

    fun getShops(): List<Shop>{
        return shopRepo.findAll()
    }

    fun getShopById(shopId: Long): Shop{
        return shopRepo.getById(shopId)
    }

}