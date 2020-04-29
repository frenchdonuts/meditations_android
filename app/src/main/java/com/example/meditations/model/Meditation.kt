package com.example.meditations.model


data class Meditation(val id: String,
                      val text: String) {
    companion object {
        fun from(meditation: com.example.meditations.Meditation): Meditation {
            return Meditation(
                meditation.id.toString(),
                meditation.text
            )
        }
    }
}