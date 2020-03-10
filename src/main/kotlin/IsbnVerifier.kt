class IsbnVerifier {

    fun isValid(number: String): Boolean {

        return number
                .filter { it != '-' }.toList()
                .apply { if (size != 10) return false }
                .apply { if (!dropLast(1).all { it.isDigit() }) return false }
                .apply { if (!last().isDigit() && last() != 'X') return false}
                .map { if (it == 'X') 10 else "$it".toInt() }
                .reversed()
                .mapIndexed{ index, digit -> digit * (index + 1) }
                .sum() % 11 == 0
    }
}
