package com.example.hangmanapp



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import com.example.hangmanapp.databinding.MainGamePanelBinding

class MainGamePanel : Fragment() {

    private lateinit var binding: MainGamePanelBinding
    private val gameViewModel: GameViewModel by viewModels()

    private fun getIndices(gameWord: String, guessedCharacter: String): List<Int> {
        var index = gameWord.indexOf(guessedCharacter)
        val indicesList: MutableList<Int> = mutableListOf()
        return if(index==-1)
            indicesList
        else {
            while (index != -1) {
                indicesList.add(index)
                index = gameWord.indexOf(guessedCharacter, index + 1)
            }
            return indicesList
        }
    }

    private fun getHangmanImage(guesses: Int): Int {
        if(guesses == 1)
            return R.drawable.game1
        else if (guesses == 2)
            return R.drawable.game2
        else if (guesses == 3)
            return R.drawable.game3
        else if (guesses == 4)
            return R.drawable.game4
        else if (guesses == 5)
            return R.drawable.game5
        else if (guesses == 6)
            return R.drawable.game6
        else
            return R.drawable.game7
    }

    private fun fillBlanks(result: String, hint: Boolean){
        binding.apply {
            val indicesList = getIndices(gameViewModel.gameWord, result)
            if (indicesList.isEmpty() && !hint) {
                gameViewModel.wrongGuesses = gameViewModel.wrongGuesses + 1
                gameViewModel.hangmanImage = getHangmanImage(gameViewModel.wrongGuesses)
                hangmanImage.setImageResource(getHangmanImage(gameViewModel.wrongGuesses))
            } else {
                for (index in indicesList) {
                    when (index) {
                        0 -> {
                            gameViewModel.firstCharacter = result
                            firstCharacter.text = gameViewModel.firstCharacter
                        }

                        1 -> {
                            gameViewModel.secondCharacter = result
                            secondCharacter.text = gameViewModel.secondCharacter
                        }

                        2 -> {
                            gameViewModel.thirdCharacter = result
                            thirdCharacter.text = gameViewModel.thirdCharacter
                        }

                        3 -> {
                            gameViewModel.fourthCharacter = result
                            fourthCharacter.text = gameViewModel.fourthCharacter
                        }

                        4 -> {
                            gameViewModel.fifthCharacter = result
                            fifthCharacter.text = gameViewModel.fifthCharacter
                        }

                        else -> {
                            gameViewModel.sixthCharacter = result
                            sixthCharacter.text = gameViewModel.sixthCharacter
                        }
                    }
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainGamePanelBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFragmentResultListener("HF-MGF-1"){ key, bundle ->
            gameViewModel.hintCount = gameViewModel.hintCount+1
            if(gameViewModel.hintCount==1) {
                gameViewModel.hintText = gameViewModel.getHint()
                setFragmentResult("MGF-HF-2", bundleOf("hint" to gameViewModel.hintText))
            }
            else if(gameViewModel.wrongGuesses+1 == 7){
                Toast.makeText(activity,"Hint not available",Toast.LENGTH_SHORT).show()
            }
            else if(gameViewModel.hintCount==2) {
                val allCharacters = ('A'..'Z').toMutableList()
                var charactersToRemove = ""
                for (character: Char in gameViewModel.guessedCharacters)
                    allCharacters.remove(character)
                allCharacters.removeAll(gameViewModel.gameWord.toList())
                val halfSize = allCharacters.size / 2
                repeat(halfSize) {
                    val randomIndex = (0 until allCharacters.size).random()
                    allCharacters.removeAt(randomIndex)
                }
                for (character in allCharacters)
                    charactersToRemove += character
                gameViewModel.guessedCharacters += charactersToRemove
                setFragmentResult("MGF-CLF", bundleOf("data" to charactersToRemove))
                gameViewModel.wrongGuesses = gameViewModel.wrongGuesses + 1
                gameViewModel.hangmanImage = getHangmanImage(gameViewModel.wrongGuesses)
                binding.apply {
                    hangmanImage.setImageResource(getHangmanImage(gameViewModel.wrongGuesses))
                }
            }
            else if(gameViewModel.hintCount == 3){
                val vowels = mutableListOf('A','E','I','O','U')
                var vowelsToRemove = ""
                val guessedCharacters = gameViewModel.guessedCharacters.toSet()
                val iterator = vowels.iterator()
                while (iterator.hasNext()) {
                    val vowel = iterator.next()
                    if (vowel in guessedCharacters) {
                        iterator.remove()
                    }
                }
                for(vowel in vowels) {
                    vowelsToRemove += vowel
                    fillBlanks(vowel.toString(), true)
                }
                gameViewModel.guessedCharacters += vowelsToRemove
                setFragmentResult("MGF-CLF", bundleOf("data" to vowelsToRemove))
                gameViewModel.wrongGuesses = gameViewModel.wrongGuesses + 1
                gameViewModel.hangmanImage = getHangmanImage(gameViewModel.wrongGuesses)
                binding.apply {
                    hangmanImage.setImageResource(getHangmanImage(gameViewModel.wrongGuesses))
                }
            }

        }
        setFragmentResultListener("CLF-MGF") { key, bundle ->
            val result = bundle.getString("data").toString()
            gameViewModel.guessedCharacters += result
            fillBlanks(result, false)
            binding.apply {
                if (gameViewModel.wrongGuesses == 7){
                    gameEndText.text = "Better luck next time!"
                    gameViewModel.endText = "Better luck next time!"
                    gameViewModel.gameEnded = true
                    setFragmentResult("MGF-CLF", bundleOf("data" to "DisableAll"))
                }
                else if (firstCharacter.text!= "_" && secondCharacter.text!= "_"
                    && thirdCharacter.text!= "_" && fourthCharacter.text!= "_"
                    && fifthCharacter.text!= "_" && sixthCharacter.text!= "_"){
                    gameEndText.text = "You Won!"
                    gameViewModel.endText = "You Won!"
                    gameViewModel.gameEnded = true
                    setFragmentResult("MGF-CLF", bundleOf("data" to "DisableAll"))
                }
            }
        }
        binding.apply {
            if(gameViewModel.gameWord == "") {
                gameViewModel.gameWord = gameViewModel.getNewGameWord()
            }
            if(gameViewModel.guessedCharacters!="") {
                setFragmentResult(
                    "MGF-CLF",
                    bundleOf("data" to gameViewModel.guessedCharacters)
                )
            }
            if(gameViewModel.gameEnded) {
                setFragmentResult(
                    "MGF-CLF",
                    bundleOf("data" to "DisableAll")
                )
            }
            setFragmentResult("MGF-HF-1", bundleOf("hint" to gameViewModel.hintText))
            hangmanImage.setImageResource(gameViewModel.hangmanImage)
            firstCharacter.text = gameViewModel.firstCharacter
            secondCharacter.text = gameViewModel.secondCharacter
            thirdCharacter.text = gameViewModel.thirdCharacter
            fourthCharacter.text = gameViewModel.fourthCharacter
            fifthCharacter.text = gameViewModel.fifthCharacter
            sixthCharacter.text = gameViewModel.sixthCharacter
            gameEndText.text = gameViewModel.endText
            newGameButton.setOnClickListener(){
                gameEndText.text = ""
                firstCharacter.text = "_"
                secondCharacter.text = "_"
                thirdCharacter.text = "_"
                fourthCharacter.text = "_"
                fifthCharacter.text = "_"
                sixthCharacter.text = "_"
                hangmanImage.setImageResource(R.drawable.game0)
                gameViewModel.wrongGuesses = 0
                gameViewModel.guessedCharacters = ""
                gameViewModel.endText = ""
                gameViewModel.firstCharacter = "_"
                gameViewModel.secondCharacter = "_"
                gameViewModel.thirdCharacter = "_"
                gameViewModel.fourthCharacter = "_"
                gameViewModel.fifthCharacter = "_"
                gameViewModel.sixthCharacter = "_"
                gameViewModel.hangmanImage = R.drawable.game0
                gameViewModel.gameEnded = false
                gameViewModel.hintCount = 0
                gameViewModel.gameWord = gameViewModel.getNewGameWord()
                gameViewModel.hintText = ""
                setFragmentResult("MGF-HF-1", bundleOf("hint" to gameViewModel.hintText))
                setFragmentResult("MGF-CLF", bundleOf("data" to "EnableAll"))
            }
        }
    }

}