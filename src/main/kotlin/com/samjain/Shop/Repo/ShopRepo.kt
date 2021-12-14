package com.samjain.Shop.Repo

import com.samjain.Shop.Model.Shop
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.LocalDate


interface ShopRepo : JpaRepository<Shop, Long>{
    @Query("SELECT s FROM Shop s Join s.addressPeriod ap where ((ap.dateValidFrom <= :refDate) and ((ap.dateValidUntil = null) or (ap.dateValidUntil >= :refDate))or (ap.dateValidUntil >= :refDate and :futureFlag=true))")
    fun getShop(@Param ("refDate") refDate: LocalDate?, @Param ("futureFlag") futureFlag: Boolean): List<Any>

}

/*.name, s.status, s.createdAt, s.lastUpdated,*//*
((ap.dateValidFrom <= :refDate) and (ap.dateValidUntil == null or ap.dateValidUntil >= :refDate)
or ((ap.dateValidUntil >= :refDate) and (:futureFlag))*/