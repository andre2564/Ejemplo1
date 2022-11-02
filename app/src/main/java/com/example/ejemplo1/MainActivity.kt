
package com.example.ejemplo1

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity() {

    //TIPOS DE VARIABLES
    /*val constante solo para una funcion o contexto especifico
    var variable
    constant matematica general para el proyecto*/


    //variables
    private var edtUserName : EditText?=null
    private  var edtPassword : TextInputEditText?=null
    private var cboxTermCond : CheckBox?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.edtUserName))

        edtUserName=findViewById(R.id.edtUserName)
        edtPassword=findViewById(R.id.edtPassword)
    }

    //primera funcion, funcionalidad login
    //el primer view se le puede cambiar el nombre para identificarlo mejor

    fun onLogin(botonLogin: View) {
        var username: String=edtUserName!!.text.toString()
        var password: String=edtPassword!!.text.toString()
        var checked: Boolean=cboxTermCond!!.isChecked

        if(username=="andreroap12@hotmail.com"){
            if(password=="0000"){
                if(checked) {
                    val negativeButton = { _: DialogInterface, _: Int -> }
                    val positiveButton = { dialog: DialogInterface, which: Int ->
                        val intent = Intent(this, WelcomeActivity::class.java)
                        startActivity(intent)
                    }
                    val dialog = AlertDialog.Builder(this)
                        .setTitle(R.string.text_welcome)
                        .setMessage("User: " + username)
                        .setPositiveButton("ok", positiveButton)
                        .setNegativeButton("Cancelar", negativeButton)
                        .create()
                        .show()
                }
                else{
                    val dialog=AlertDialog.Builder(this)
                        .setTitle("ERROR!!!")
                        .setMessage(getString(R.string.errortermscond))
                        .create()
                        .show()
                }

            }
            else{

                val dialog=AlertDialog.Builder(this)
                    .setTitle("ERROR!!!")
                    .setMessage(getString(R.string.errorpassword))
                    .create()
                    .show()
            }
        }
        else{
            val dialog=AlertDialog.Builder(this)
                .setTitle("ERROR")
                .setMessage(getString(R.string.errorusername))
                .create()
                .show()

            //Toast.makeText(this,getString(R.string.errorusername),Toast.LENGTH_LONG)
        }
    }
}