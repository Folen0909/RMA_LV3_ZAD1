package hr.ferit.lv3_zad1.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hr.ferit.lv3_zad1.R
import hr.ferit.lv3_zad1.databinding.ActivityMainBinding
import hr.ferit.lv3_zad1.model.BirdCounter
import hr.ferit.lv3_zad1.persistence.PreferenceManager
import hr.ferit.lv3_zad1.utilities.getColorResource

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private var birdCounter: BirdCounter = BirdCounter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        loadData()
        bindData()
        setContentView(mainBinding.root)
    }

    private fun saveData() {
        PreferenceManager().saveCounter(birdCounter.counter.toString())
        PreferenceManager().saveColor(birdCounter.color)
    }

    private fun loadData() {
        birdCounter.counter = PreferenceManager().retrieveCounter().toInt()
        birdCounter.color = PreferenceManager().retrieveColor()
    }
    private fun bindData() {
        mainBinding.tvTotalBirds.text = birdCounter.counter.toString()
        mainBinding.tvTotalBirds.setBackgroundResource(getColorResource(birdCounter.color))
        mainBinding.bReset.setOnClickListener { clearData() }
        mainBinding.bGreyBird.setOnClickListener { birdSpotted("grey") }
        mainBinding.bBlueBird.setOnClickListener { birdSpotted("blue") }
        mainBinding.bRedBird.setOnClickListener { birdSpotted("red") }
        mainBinding.bGreenBird.setOnClickListener { birdSpotted("green") }
    }

    private fun birdSpotted(color: String) {
        birdCounter.color = color
        birdCounter.counter++
        saveData()
        updateUi()
    }

    private fun updateUi() {
        mainBinding.tvTotalBirds.text = birdCounter.counter.toString()
        mainBinding.tvTotalBirds.setBackgroundResource(getColorResource(birdCounter.color))
    }

    private fun clearData() {
        birdCounter.color = "white"
        birdCounter.counter = 0
        saveData()
        updateUi()
    }
}