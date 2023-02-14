package com.example.day3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {


    lateinit var  textInputEditText:TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textInputLayout = findViewById<TextInputLayout>(R.id.inputTextLayout)
        textInputEditText = findViewById<TextInputEditText>(R.id.textInputEditText)
        val checkBox = findViewById<CheckBox>(R.id.agree_checkbox)
        val logButton = findViewById<Button>(R.id.log_button)
        val contentLayout = findViewById<LinearLayout>(R.id.content_layout)
        val progressBarLayout = findViewById<LinearLayout>(R.id.progress_bar_layout)


        logButton.isEnabled =false
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            logButton.isEnabled = isChecked
        }





        textInputEditText.listenerChanges {
            textInputLayout.isErrorEnabled = false
        }

        logButton.setOnClickListener{
            hideKeyboard(textInputEditText)
            if (android.util.Patterns.EMAIL_ADDRESS.matcher(textInputEditText.text.toString()).matches()){
                Snackbar.make(logButton,"go to postLogin",Snackbar.LENGTH_LONG).show()
                contentLayout.visibility = View.GONE
                progressBarLayout.visibility = View.VISIBLE
                Handler(Looper.myLooper()!!).postDelayed({
                    contentLayout.visibility = View.VISIBLE
                    progressBarLayout.visibility = View.GONE
                    val bottomSheetDialog= BottomSheetDialog(this)
                    val view = LayoutInflater.from(this).inflate(R.layout.dialog,contentLayout,false)
                    bottomSheetDialog.setCancelable(false)
                    view.findViewById<ImageButton>(R.id.cancelBut).setOnClickListener { bottomSheetDialog.dismiss()}
                    bottomSheetDialog.setContentView(view)
                    bottomSheetDialog.show()
                },3000)
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