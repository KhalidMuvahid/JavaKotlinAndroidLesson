package com.example.day3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {


    lateinit var  textInputEditText:TextInputEditText;

  /*  val textWatcher = object : MyTextWatcher() {

        override fun afterTextChanged(s: Editable?) {
            val input = s.toString()
            if (input.endsWith("@g")){
                val fullMail = "${input}mail.com"
                setText("${input}mail.com")
            }
            val valid = android.util.Patterns.EMAIL_ADDRESS.matcher(input).matches()
            textInputLayout.isErrorEnabled = !valid
            val error = if (valid)"" else getString(R.string.invalid_email_message)
            textInputLayout.error = error
            if (valid) Toast.makeText(this@MainActivity,R.string.valid_email_message,Toast.LENGTH_SHORT).show()

        }

        private fun setText(text: String){
        textInputEditText.removeTextChangedListener(textWatcher)
        textInputEditText.setTextCorrectly(text)
        }

         fun TextInputEditText.setTextCorrectly(text:CharSequence){
        setText(text)
        setSelection(text.length)
        }

        textInputEditText.addTextChangedListener(textWatcher)

    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textInputLayout = findViewById<TextInputLayout>(R.id.inputTextLayout)
        textInputEditText = findViewById<TextInputEditText>(R.id.textInputEditText)
        val logButton = findViewById<Button>(R.id.log_button)

        textInputEditText.listenerChanges {
            textInputLayout.isErrorEnabled = false
        }

        logButton.setOnClickListener{
            hideKeyboard(textInputEditText)
            if (android.util.Patterns.EMAIL_ADDRESS.matcher(textInputEditText.text.toString()).matches()){
                Snackbar.make(logButton,"go to postLogin",Snackbar.LENGTH_LONG).show()
            }else{
                textInputLayout.isErrorEnabled = true
                textInputLayout.error = getString(R.string.invalid_email_message)
            }
        }


    }


    private fun TextInputEditText.listenerChanges(block:(text:String)->Unit){
        addTextChangedListener(object:MyTextWatcher(){
            override fun afterTextChanged(s: Editable?) {
                block.invoke(s.toString())
            }
        })
    }

    private fun AppCompatActivity.hideKeyboard(view: View){
        val imm = this.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}