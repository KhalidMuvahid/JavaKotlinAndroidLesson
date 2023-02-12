package com.example.day1

import android.app.Application
import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.annotation.RequiresApi

class App: Application() {

    lateinit var  html: MyHtml

    override fun onCreate() {
        super.onCreate()

        html = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            MyHtml.Higher24()
        }else{
            MyHtml.Under24()
        }


    }
}

interface MyHtml{
    fun spannable(str:String):Spanned

    class Under24() : MyHtml{
        override fun spannable(str: String): Spanned {
            return Html.fromHtml(str)
        }
    }

    class Higher24():MyHtml{
        @RequiresApi(Build.VERSION_CODES.N)
        override fun spannable(str: String): Spanned {
            return Html.fromHtml(str,0)
        }

    }

}
