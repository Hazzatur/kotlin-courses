package com.example.superhumanregistrationact

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class SuperHuman (val name: String, val alterEgo: String, val biography: String, val powerLevel: Float) : Parcelable
