package top.kikt.usegolibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.text = "come from jni ${JniLibrary.add(300, 150)}"

        textView2.text = "come from jni ${JniLibrary.remove(300, 150)}"
    }


}