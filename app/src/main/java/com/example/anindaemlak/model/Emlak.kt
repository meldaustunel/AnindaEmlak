package com.example.anindaemlak.model

data class Emlak(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<Result>
){
data class Result(
    val address: Address,
    val balcony_exist: Boolean,
    val building_age: String,
    val created_at: String,
    val description: String,
    val exterior_feature: List<String>,
    val fee: Int,
    val floor_number: String,
    val frontal: List<String>,
    val heating: String,
    val id: Int,
    val interior_feature: List<String>,
    val landscape: List<String>,
    val locality: List<String>,
    val number_of_bathroom: String,
    val number_of_floor: String,
    val number_of_rooms: String,
    val photos: List<Photo>,
    val price: Int,
    val square_meter: Int,
    val square_meter_net: Int,
    val status: String,
    val suitable_for_disabled: List<String>,
    val time_since_pub: String,
    val title: String,
    val transportation: List<String>,
    val updated_at: String,
    val using_status: String,
    val visibility: String
)
data class Photo(
    val caption: String,
    val `file`: String,
    val id: Int
)
}