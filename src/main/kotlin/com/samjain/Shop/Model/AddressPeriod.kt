package com.samjain.Shop.Model

import javax.persistence.*

@Entity
class AddressPeriod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long=0
    @Column
    var dateValidFrom:String?=null
    @Column
    var dateValidUntill:String?=null
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "fk_storeAddress_id")
    var shopAddress : ShopAddress?=null
}