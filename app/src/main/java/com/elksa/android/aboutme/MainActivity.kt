package com.elksa.android.aboutme

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.elksa.android.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    private lateinit var myName: MyName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        myName = MyName(name = getString(R.string.alejo_casanova))
        binding.myName = myName

        /*findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        }*/

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {

        //val editText = findViewById<EditText>(R.id.nickname_edit)
        //val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        binding.apply {
            invalidateAll()
            //binding.nicknameText.text = binding.nicknameEdit.text
            myName?.nickName = binding.nicknameEdit.text.toString()
            binding.nicknameEdit.visibility = View.GONE
            view.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
        }

        // Hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
