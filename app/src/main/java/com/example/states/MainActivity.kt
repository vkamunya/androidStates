package com.example.states

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.states.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

   lateinit var data: SharedPreferences
   lateinit var editdata:SharedPreferences.Editor



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //initialization
        data=applicationContext.getSharedPreferences("mydata",MODE_PRIVATE)
        editdata=data.edit()

        binding=ActivityMainBinding.inflate(layoutInflater)
        var view=binding.root
        setContentView(view)
        Toast.makeText(applicationContext,"onCreate",Toast.LENGTH_SHORT).show()
        binding.save.setOnClickListener{
            saveData()
        }
        binding.retrieve.setOnClickListener{
            retrieveData()
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(applicationContext,"onCreate",Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        //retrieving data
        retrieveData()
        Toast.makeText(applicationContext,"onCreate",Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        //save
        saveData()
        Toast.makeText(applicationContext,"onCreate",Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(applicationContext,"onCreate",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext,"onCreate",Toast.LENGTH_SHORT).show()
    }
    fun saveData(){
        editdata=data.edit()
        editdata.putString("message",binding.message.text.toString())
        editdata.apply()
    }
    fun retrieveData(){
        binding.message.setText(data.getString("message",""))

    }
}