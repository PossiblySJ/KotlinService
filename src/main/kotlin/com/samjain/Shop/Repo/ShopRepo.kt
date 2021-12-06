package com.samjain.Shop.Repo

import com.samjain.Shop.Model.Shop
import org.springframework.data.jpa.repository.JpaRepository

interface ShopRepo : JpaRepository<Shop, Long>{
}