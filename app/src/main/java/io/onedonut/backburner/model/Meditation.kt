package io.onedonut.backburner.model


data class Meditation(val id: String,
                      val text: String) {
    companion object {
        fun from(meditation: io.onedonut.backburner.Meditation): Meditation {
            return Meditation(
                meditation.id.toString(),
                meditation.text
            )
        }
    }
}