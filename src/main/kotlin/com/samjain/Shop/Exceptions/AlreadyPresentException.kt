package com.samjain.Shop.Exceptions

class AlreadyPresentException (val storeName:String ) :Exception("Information for $storeName already exists.")