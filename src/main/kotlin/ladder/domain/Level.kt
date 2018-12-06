package ladder.domain

enum class Level(private val levelName: String,
                 private val height: Int,
                 private val percent: Float) {
    HIGH("상", 20, 0.8F),
    MEDIUM("중", 10, 0.5F),
    LOW("하", 5, 0.3F);

    fun getPercent(): Float = percent

    fun getHeight(): Int = height

    companion object {
        fun findLevel(levelName: String): Level =
                values()
                        .find { it.levelName == levelName }
                        ?: throw IllegalArgumentException("존재하지 않는 난이도입니다.")
    }
}
