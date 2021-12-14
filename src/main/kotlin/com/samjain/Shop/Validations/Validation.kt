package com.samjain.Shop.Validations

import com.samjain.Shop.Model.Shop
import com.samjain.Shop.Model.AddressPeriod
import com.samjain.Shop.Repo.ShopRepo
import com.samjain.Shop.Exceptions.AlreadyPresentException
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Service
class Validation  (val shopRepo: ShopRepo){
    fun validData(shop: Shop):Boolean
    {
        val addressPeriod:List<AddressPeriod>? =shop.addressPeriod
        if(shop.name==null||shop.status==null||shop.addressPeriod!!.isEmpty())

        {
            return false
        }
        for(data in addressPeriod!!) {
            if(data.shopAddress==null)
            {
                return false
            }

            if(data.dateValidFrom==null||data.shopAddress!!.street==null||data.shopAddress!!.houseNumber==null||data.shopAddress!!.houseNumberSuffix==null||data.shopAddress!!.postalCode==null||data.shopAddress!!.city==null||data.shopAddress!!.country==null)
            {
                return false
            }
        }

        var result=shopRepo.findAll()

        /*for(data in result)
        {
            if(data.name==shop.name)
            {
                throw AlreadyPresentException(shop.name!!)

            }
        }
*/
        /*result.forEach{
            if(it.name==shop.name)

        }

         */
        return true


    }



    fun validDateFormat(refDate: String?): LocalDate? {
        var date: LocalDate? = null
        if (refDate != null) {
            date = LocalDate.parse(refDate, DateTimeFormatter.ISO_DATE)
            return date
        }
        return date
    }
}