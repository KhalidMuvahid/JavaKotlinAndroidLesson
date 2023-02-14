package com.example.day3

import android.app.Dialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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


    private companion object {
        const val INITIAL = 0
        const val PROGRESS = 1
        const val SUCCESS = 2
        const val FAILED = 3

        const val STATE_KEY = "screenState";
    }

    private var state = INITIAL
    lateinit var textInputEditText: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState?.let {
            state = it.getInt(STATE_KEY)
        }

        val textInputLayout = findViewById<TextInputLayout>(R.id.inputTextLayout)
        textInputEditText = findViewById<TextInputEditText>(R.id.textInputEditText)
        val checkBox = findViewById<CheckBox>(R.id.agree_checkbox)
        val logButton = findViewById<Button>(R.id.log_button)
        val contentLayout = findViewById<LinearLayout>(R.id.content_layout)
        val progressBarLayout = findViewById<LinearLayout>(R.id.progress_bar_layout)


        when (state) {
            FAILED -> showMyDialog(contentLayout)
            SUCCESS -> {
                Snackbar.make(contentLayout, "Success", Snackbar.LENGTH_LONG).show()
                state = INITIAL
            }
        }

        logButton.isEnabled = false
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            logButton.isEnabled = isChecked
        }

        textInputEditText.listenerChanges {
            textInputLayout.isErrorEnabled = false
        }

        logButton.setOnClickListener {
            if (android.util.Patterns.EMAIL_ADDRESS.matcher(textInputEditText.text.toString())
                    .matches()
            ) {
                hideKeyboard(textInputEditText)
                contentLayout.visibility = View.GONE
                progressBarLayout.visibility = View.VISIBLE
                state = PROGRESS
                Handler(Looper.myLooper()!!).postDelayed({
                    state = FAILED
                    contentLayout.visibility = View.VISIBLE
                    progressBarLayout.visibility = View.GONE
                    showMyDialog(contentLayout)
                }, 3000)
            } else {
                textInputLayout.isErrorEnabled = true
                textInputLayout.error = getString(R.string.invalid_email_message)
            }
        }


    }

    private fun TextInputEditText.listenerChanges(block: (text: String) -> Unit) {
        addTextChangedListener(object : MyTextWatcher() {
            override fun afterTextChanged(s: Editable?) {
                block.invoke(s.toString())
            }
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(STATE_KEY, state)
    }

    private fun showMyDialog(viewGroup: ViewGroup) {
        val dialog = Dialog(this)
        val view = LayoutInflater.from(this).inflate(R.layout.dialog, viewGroup, false)
        dialog.setCancelable(false)
        view.findViewById<View>(R.id.cancelBut).setOnClickListener {
            state = INITIAL
            dialog.dismiss()
        }
        dialog.setContentView(view)
        dialog.show()
    }

    //region hide key
    private fun AppCompatActivity.hideKeyboard(view: View) {
        val imm = this.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
    //endregion

}