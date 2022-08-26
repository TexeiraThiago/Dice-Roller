package br.com.firstaplication.dice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.btnRoll)
        rollButton.setOnClickListener { rollDice() }

        // Do a dice roll when app starts
        rollDice();
    }
    /**
     * Roll the dice and update the screen with the result
     */
    private fun rollDice() {
        // Create a new object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Find imageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determine wich drawable rouserce ID to use on be the dice roll
        val drawarbleResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update screen with the correct drawable resouce ID
        diceImage.setImageResource(drawarbleResource)
        // Update content description
        diceImage.contentDescription = diceRoll.toString()

    }
}