package edu.student.apppreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val et1 = findViewById<EditText>(R.id.txtEmail) as EditText
        //We obtain a reference from an object of the SharedPreferences
        //class through the inherited getSharedPreferences method of the AppCompatActivity class.


        val preferences = getSharedPreferences ("data", Context.MODE_PRIVATE)

        et1.setText (preferences.getString ("mail", ""))
        val button1 = findViewById <Button>(R.id.btnSubmit) as Button
        //When you press the “save preferences” button, what we do is to save the contents of
        //the EditText in a variable called “mail” in the preferences file:
        button1.setOnClickListener {
            val editor = preferences.edit ()
            editor.putString ("mail", txtEmail.text.toString ())
            editor.commit ()
            //the finish method of the AppCompatActivity class ends the current activity
            // finish()
        }
        //Fire hidekeyboard when user taps outside any text object
//Place below code right before last right bracket in function onCreate
        findViewById<View>(android.R.id.content).setOnTouchListener { _, _ ->
            hideKeyboard()
            false
        }
    }

    //function to hide keyboard goes right before the last right bracket of Class MainActivity
//should auto import android.content.Context
//should auto add import android.view.inputmethod.InputMethodManager
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }

    }
}

