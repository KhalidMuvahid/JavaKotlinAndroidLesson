package com.example.day1

import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val agreementTextView = findViewById<TextView>(R.id.agreementTextView);
        agreementTextView.setColor(Color.parseColor("#FF2175DC"))
      /*  agreementTextView.text =
            (application as App).html.spannable(application.getString(R.string.html))*/

        val fullText = getString(R.string.agreement_full_text)
        val confidential = getString(R.string.confidential_info)
        val privacyPolicy = getString(R.string.privacy_policy)
        val spannableString = SpannableString(fullText)

        val confidentialClickable = object : ClickableSpan() {
            override fun onClick(widget: View) {
                Snackbar.make(widget, "Go to link1", Snackbar.LENGTH_LONG)
                    .setAction("ok", View.OnClickListener { }).show();
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = true;
                ds.color = Color.parseColor("#FF2175DC")
            }
        }

        val policyClickable = object : ClickableSpan() {
            override fun onClick(widget: View) {
                Snackbar.make(widget, "Go to link2", Snackbar.LENGTH_LONG)
                    .setAction("ok", View.OnClickListener { }).show();
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = true;
                ds.color = Color.GREEN
            }
        }

        spannableString.setSpan(
            confidentialClickable,
            fullText.indexOf(confidential),
            fullText.indexOf(confidential)+confidential.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        spannableString.setSpan(
            policyClickable,
            fullText.indexOf(privacyPolicy),
            fullText.indexOf(privacyPolicy)+privacyPolicy.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        agreementTextView.run {
            text = spannableString
            movementMethod = LinkMovementMethod.getInstance()
            highlightColor = Color.TRANSPARENT
        }

    }

    private fun TextView.setColor(colorId: Int, theme: Resources.Theme? = null) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setTextColor(resources.getColor(R.color.black, null))
        } else {
            setTextColor(resources.getColor(R.color.red))
        }
    }
}