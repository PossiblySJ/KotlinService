package com.samjain.Shop.Service

import com.samjain.Shop.Exceptions.NullInputFieldException
import com.samjain.Shop.Model.Shop
import com.samjain.Shop.Repo.ShopRepo
import com.samjain.Shop.Validations.Validation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class ShopService {
    @Autowired
    lateinit var shopRepo: ShopRepo

    @Autowired
    lateinit var validation: Validation

    fun getShops(refDate:String?,FutureFlag:Boolean): List<Any>{
        return shopRepo.getShop()

        /*val date:LocalDate?=validation.validDateFormat(refDate)
        var result= shopRepo.findAll()
        if(result.isEmpty())
        {
            throw NoSuchElementException()
        }
        return if(date==null) {
            result
        } else if (FutureFlag) {

            currentFutureRecords(result, date)
        } else {

            currentRecords(result, date)
        }*/

    }

    fun currentRecords(result: List<Shop>, date: LocalDate): List<Shop>{
        for(data in result)
        {
            data.addressPeriod=data.addressPeriod!!.filter{filterData->(filterData.dateValidFrom!! <=date&&(filterData.dateValidUntil==null||filterData.dateValidUntil!!>=date)||(filterData.dateValidFrom!! >=date&&(filterData.dateValidUntil==null||filterData.dateValidUntil!!>=date)))}
        }
        return result
    }

    fun currentFutureRecords(result: List<Shop>, date: LocalDate): List<Shop>{
        for(data in result)
        {
            data.addressPeriod=data.addressPeriod!!.filter{filterData->(filterData.dateValidFrom!! <=date&&(filterData.dateValidUntil==null||filterData.dateValidUntil!!>=date)||(filterData.dateValidFrom!! >=date&&(filterData.dateValidUntil==null||filterData.dateValidUntil!!>=date)))}
        }
        return result
    }

    fun getShopById(shopId: Long): Shop{
        return shopRepo.getById(shopId)
    }

    fun addShop(shop: Shop): String {

        shop.createdAt = LocalDateTime.now()
        shop.lastUpdated = LocalDateTime.now()
        if( validation.validData(shop))
        {
            shopRepo.save(shop)
            return "Saved"}
        else
        {  throw NullInputFieldException()
        }


    }

}