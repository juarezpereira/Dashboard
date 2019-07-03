package com.example.dashboard

import java.io.Serializable

interface ViewType : Serializable {
    fun getViewType(): Int
}