package com.samjain.Shop.Service

import com.samjain.Shop.Model.Shop
import com.samjain.Shop.Repo.ShopRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Service
class ShopService {
    @Autowired
    lateinit var shopRepo: ShopRepo

    fun getShops(refDate:String?,FutureFlag:Boolean): List<Shop>{

        var date = LocalDate.parse(refDate, DateTimeFormatter.ISO_DATE)
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
        }

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

}