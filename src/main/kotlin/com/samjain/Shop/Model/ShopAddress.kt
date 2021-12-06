package com.samjain.Shop.Model

import javax.persistence.*

@Entity
class ShopAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long=0

    @Column
    var street : String?=null
    @Column
    var houseNumber : String?=null
    @Column
    var houseNumberSuffix : String?=null
    @Column
    var postalCode : String?=null
    @Column
    var city : String?=null
    @Column
    var country : String?=null


}