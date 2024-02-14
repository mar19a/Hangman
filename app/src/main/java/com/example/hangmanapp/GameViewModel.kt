package com.example.hangmanapp


import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlin.random.Random


const val FIRST_CHARACTER_KEY = "FIRST_CHARACTER_KEY"
const val SECOND_CHARACTER_KEY = "SECOND_CHARACTER_KEY"
const val THIRD_CHARACTER_KEY = "THIRD_CHARACTER_KEY"
const val FOURTH_CHARACTER_KEY = "FOURTH_CHARACTER_KEY"
const val FIFTH_CHARACTER_KEY = "FIFTH_CHARACTER_KEY"
const val SIXTH_CHARACTER_KEY = "SIXTH_CHARACTER_KEY"
const val HANGMAN_IMAGE_KEY = "HANGMAN_IMAGE_KEY"
const val WRONG_GUESSES_KEY = "WRONG_GUESSES_KEY"
const val END_TEXT_KEY = "END_TEXT_KEY"
const val GUESSED_CHARACTERS_KEY= "GUESSED_CHARACTERS_KEY"
const val GAME_WORD_KEY = "GAME_WORD_KEY"
const val GAME_ENDED_KEY = "GAME_ENDED_KEY"
const val HINT_COUNT_KEY = "HINT_COUNT_KEY"
const val WORD_INDEX_KEY = "WORD_INDEX_KEY"
const val HINT_TEXT_KEY = "HINT_TEXT_KEY"

class GameViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    var words: List<String> = listOf("BANANA","RABBIT","MEXICO","BOXING","CARROT")

    private var hints: List<String> = listOf("FRUIT","ANIMAL","COUNTRY","SPORT","VEGETABLE")
    fun getNewGameWord(): String {
        val randomIndex = Random.nextInt(words.size)
        wordIndex = randomIndex
        return words[randomIndex]
    }

    fun getHint(): String{
        return hints[wordIndex]
    }

    var firstCharacter: String
        get() = savedStateHandle[FIRST_CHARACTER_KEY] ?: "_"
        set(value) = savedStateHandle.set(FIRST_CHARACTER_KEY, value)

    var secondCharacter: String
        get() = savedStateHandle[SECOND_CHARACTER_KEY] ?: "_"
        set(value) = savedStateHandle.set(SECOND_CHARACTER_KEY, value)

    var thirdCharacter: String
        get() = savedStateHandle[THIRD_CHARACTER_KEY] ?: "_"
        set(value) = savedStateHandle.set(THIRD_CHARACTER_KEY, value)

    var fourthCharacter: String
        get() = savedStateHandle[FOURTH_CHARACTER_KEY] ?: "_"
        set(value) = savedStateHandle.set(FOURTH_CHARACTER_KEY, value)

    var fifthCharacter: String
        get() = savedStateHandle[FIFTH_CHARACTER_KEY] ?: "_"
        set(value) = savedStateHandle.set(FIFTH_CHARACTER_KEY, value)

    var sixthCharacter: String
        get() = savedStateHandle[SIXTH_CHARACTER_KEY] ?: "_"
        set(value) = savedStateHandle.set(SIXTH_CHARACTER_KEY, value)

    var hangmanImage: Int
        get() = savedStateHandle[HANGMAN_IMAGE_KEY] ?: R.drawable.game0
        set(value) = savedStateHandle.set(HANGMAN_IMAGE_KEY, value)

    var wrongGuesses: Int
        get() = savedStateHandle[WRONG_GUESSES_KEY] ?: 0
        set(value) = savedStateHandle.set(WRONG_GUESSES_KEY, value)

    var endText: String
        get() = savedStateHandle[END_TEXT_KEY] ?: ""
        set(value) = savedStateHandle.set(END_TEXT_KEY, value)

    var guessedCharacters: String
        get() = savedStateHandle[GUESSED_CHARACTERS_KEY] ?: ""
        set(value) = savedStateHandle.set(GUESSED_CHARACTERS_KEY, value)

    var gameWord: String
        get() = savedStateHandle[GAME_WORD_KEY] ?: ""
        set(value) = savedStateHandle.set(GAME_WORD_KEY, value)

    var gameEnded: Boolean
        get() = savedStateHandle[GAME_ENDED_KEY] ?: false
        set(value) = savedStateHandle.set(GAME_ENDED_KEY, value)

    var hintCount: Int
        get() = savedStateHandle[HINT_COUNT_KEY] ?: 0
        set(value) = savedStateHandle.set(HINT_COUNT_KEY, value)

    private var wordIndex: Int
        get() = savedStateHandle[WORD_INDEX_KEY] ?: 0
        set(value) = savedStateHandle.set(WORD_INDEX_KEY, value)

    var hintText: String
        get() = savedStateHandle[HINT_TEXT_KEY] ?: ""
        set(value) = savedStateHandle.set(HINT_TEXT_KEY, value)

}