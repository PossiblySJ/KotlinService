package com.samjain.Shop.Repo

import com.samjain.Shop.Model.Shop
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ShopRepo : JpaRepository<Shop, Long>{
    @Query("SELECT s FROM Shop s Join s.addressPeriod ap where ap.dateValidFrom<'2000-03-02' ")
    fun getShop(): List<Any>
}

/*.name, s.status, s.createdAt, s.lastUpdated,*/