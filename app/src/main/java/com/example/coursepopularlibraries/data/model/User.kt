package com.example.coursepopularlibraries.data.model

import com.google.gson.annotations.SerializedName

data class User(
    val name: String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("html_url")
    val htmlURL: String,
    val description: String? = null,
    @SerializedName("releases_url")
    val releasesURL: String,
    @SerializedName("deployments_url")
    val deploymentsURL: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("pushed_at")
    val pushedAt: String,
    val language: String? = null,
)

