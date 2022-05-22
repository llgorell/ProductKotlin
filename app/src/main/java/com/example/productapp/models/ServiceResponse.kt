package com.example.productapp.models

data class ServiceResponse <T>(
    var data : T? = null,
    var message : String? = null,
    var status :String? = null,
    var totalCount : Long? = null
)
